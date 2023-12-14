package com.tune.novel.manager.cache;

import com.tune.novel.core.constant.CacheConsts;
import com.tune.novel.mapper.BookChapterMapper;
import com.tune.novel.model.dto.resp.BookChapterRespDto;
import com.tune.novel.model.entity.BookChapter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Tune
 * @create 2023-12-13-21:57
 * @description: 小说章节 缓存管理类
 */
@Component
@RequiredArgsConstructor
public class BookChapterCacheManager {

    private final BookChapterMapper bookChapterMapper;

    /**
     * 查询小说章节信息，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
            value = CacheConsts.BOOK_CHAPTER_CACHE_NAME)
    public BookChapterRespDto getChapter(Long chapterId) {
        BookChapter bookChapter = bookChapterMapper.selectById(chapterId);
        return BookChapterRespDto.builder()
                .id(chapterId)
                .bookId(bookChapter.getBookId())
                .chapterNum(bookChapter.getChapterNum())
                .chapterName(bookChapter.getChapterName())
                .chapterWordCount(bookChapter.getWordCount())
                .chapterUpdateTime(bookChapter.getUpdateTime())
                .isVip(bookChapter.getIsVip())
                .build();
    }
}
