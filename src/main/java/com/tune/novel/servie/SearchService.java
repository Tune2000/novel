package com.tune.novel.servie;

import com.tune.novel.core.common.resp.PageRespDto;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.req.BookSearchReqDto;
import com.tune.novel.model.dto.resp.BookInfoRespDto;

/**
 * @author Tune
 * @create 2023-12-17-15:15
 * @description: 搜索 服务类
 */
public interface SearchService {
    /**
     * 小说搜索
     *
     * @param condition 搜索条件
     * @return 搜索结果
     */
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);

}
