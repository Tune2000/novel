package com.tune.novel.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.tune.novel.core.constant.CacheConsts;
import com.tune.novel.mapper.BookInfoMapper;
import com.tune.novel.mapper.HomeBookMapper;
import com.tune.novel.model.dto.resp.HomeBookRespDto;
import com.tune.novel.model.entity.BookInfo;
import com.tune.novel.model.entity.HomeBook;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Tune
 * @create 2023-12-09-15:40
 * @description:
 * 首页推荐小说 缓存管理类
 * 首页是小说门户的入口，承载着系统很大一部分流量，并且内容不需要实时更新。所以首页相关内容的查询最好都做缓存处理
 * 该方法执行数据库查询逻辑并进行简单的处理得到我们需要的数据格式并通过 @Cacheable 注解缓存起来。
 * 该方法下次再被调用时会直接从缓存中拿取数据而不需要再一次查询数据库并处理，减轻数据库的压力。
 */
@Component
@RequiredArgsConstructor
public class HomeBookCacheManager {

    private final HomeBookMapper homeBookMapper;

    private final BookInfoMapper bookInfoMapper;

    /**
     * 查询首页小说推荐，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER
            , value = CacheConsts.HOME_BOOK_CACHE_NAME)
    public List<HomeBookRespDto> listHomeBooks() {
        // 从首页小说推荐表中查询出需要推荐的小说
        List<HomeBook> homeBooks = homeBookMapper.selectList(null);

        // 获取推荐小说ID列表
        if (!CollectionUtils.isEmpty(homeBooks)) {
            List<Long> bookIds = homeBooks.stream().map(HomeBook::getBookId).collect(Collectors.toList());

            // 根据小说ID列表查询相关的小说信息列表
            QueryWrapper<BookInfo> bookInfoQueryWrapper = new QueryWrapper<>();
            bookInfoQueryWrapper.in("id", bookIds);
            List<BookInfo> bookInfos = bookInfoMapper.selectList(bookInfoQueryWrapper);

            // 组装 HomeBookRespDto 列表数据并返回
            if(!CollectionUtils.isEmpty(bookInfos)){
                Map<Long, BookInfo> bookInfoMap = bookInfos.stream()
                        .collect(Collectors.toMap(BookInfo::getId, Function.identity()));
                return homeBooks.stream().map(v -> {
                    BookInfo bookInfo = bookInfoMap.get(v.getBookId());
                    HomeBookRespDto bookRespDto = new HomeBookRespDto();
                    bookRespDto.setBookId(v.getBookId());
                    bookRespDto.setType(v.getType());
                    bookRespDto.setBookName(bookInfo.getBookName());
                    bookRespDto.setPicUrl(bookInfo.getPicUrl());
                    bookRespDto.setAuthorName(bookInfo.getAuthorName());
                    bookRespDto.setBookDesc(bookInfo.getBookDesc());
                    return bookRespDto;
                }).collect(Collectors.toList());

            }

        }

        return Collections.emptyList();
    }
}
