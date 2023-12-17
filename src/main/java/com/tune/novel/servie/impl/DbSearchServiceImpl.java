package com.tune.novel.servie.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tune.novel.core.common.resp.PageRespDto;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.mapper.BookInfoMapper;
import com.tune.novel.model.dto.req.BookSearchReqDto;
import com.tune.novel.model.dto.resp.BookInfoRespDto;
import com.tune.novel.model.entity.BookInfo;
import com.tune.novel.servie.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tune
 * @create 2023-12-17-15:17
 * @description:数据库搜索 服务实现类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DbSearchServiceImpl implements SearchService {

    private final BookInfoMapper bookInfoMapper;

    @Override
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition) {
        Page<BookInfoRespDto> page = new Page<>();
        page.setCurrent(condition.getPageNum());
        page.setSize(condition.getPageSize());
        List<BookInfo> bookInfos = bookInfoMapper.searchBooks(page, condition);
        return RestResp.ok(
                PageRespDto.of(condition.getPageNum(), condition.getPageSize(), page.getTotal(),
                        bookInfos.stream().map(v -> BookInfoRespDto.builder()
                                .id(v.getId())
                                .bookName(v.getBookName())
                                .categoryId(v.getCategoryId())
                                .categoryName(v.getCategoryName())
                                .authorId(v.getAuthorId())
                                .authorName(v.getAuthorName())
                                .wordCount(v.getWordCount())
                                .lastChapterName(v.getLastChapterName())
                                .build()).collect(Collectors.toList())));
    }

}
