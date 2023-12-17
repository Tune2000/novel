package com.tune.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tune.novel.model.dto.req.BookSearchReqDto;
import com.tune.novel.model.dto.resp.BookInfoRespDto;
import com.tune.novel.model.entity.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


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

    /**
     * 小说搜索
     * @param page mybatis-plus 分页对象
     * @param condition 搜索条件
     * @return 返回结果
     * */
    List<BookInfo> searchBooks(IPage<BookInfoRespDto> page, BookSearchReqDto condition);
}
