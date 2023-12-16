package com.tune.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tune.novel.model.entity.BookInfo;
import org.apache.ibatis.annotations.Param;


/**
 * 小说信息(BookInfo)表数据库访问层
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
public interface BookInfoMapper extends BaseMapper<BookInfo> {
    /**
     * 增加小说点击量
     *
     * @param bookId 小说ID
     */
    void addVisitCount(@Param("bookId") Long bookId);
}
