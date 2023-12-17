package com.tune.novel.controller.front;

import com.tune.novel.core.common.constant.ApiRouterConsts;
import com.tune.novel.core.common.resp.PageRespDto;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.req.BookSearchReqDto;
import com.tune.novel.model.dto.resp.BookInfoRespDto;
import com.tune.novel.servie.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tune
 * @create 2023-12-17-15:13
 * @description:前台门户-搜索模块 API 控制器
 */
@Tag(name = "SearchController", description = "前台门户-搜索模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_SEARCH_URL_PREFIX)
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    /**
     * 小说搜索接口
     */
    @Operation(summary = "小说搜索接口")
    @GetMapping("books")
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(
            @ParameterObject BookSearchReqDto condition) {
        return searchService.searchBooks(condition);
    }

}