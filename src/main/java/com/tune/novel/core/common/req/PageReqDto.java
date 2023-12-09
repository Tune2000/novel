package com.tune.novel.core.common.req;

import lombok.Data;

/**
 * @author Tune
 * @create 2023-12-07-21:18
 * @description:
 * 分页请求数据格式封装类，所有分页请求的 Dto 类都应继承该类
 */
@Data
public class PageReqDto {
    /**
     * 请求页码，默认第 1 页
     * */
    private int pageNum = 1;

    /**
     * 每页大小，默认每页 10 条
     * */
    private int pageSize = 10;

    /**
     * 是否查询所有，默认不查所有
     * 为 true 时，pageNum 和 pageSize 无效
     * */
    private boolean fetchAll = false;
}
