package com.tune.novel.servie;

import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.resp.HomeBookRespDto;

import java.util.List;

/**
 * @author Tune
 * @create 2023-12-09-15:47
 * @description:
 */
public interface HomeService {
    /**
     * 查询首页小说推荐列表
     *
     * @return 首页小说推荐列表的 rest 响应结果
     * */
    RestResp<List<HomeBookRespDto>> listHomeBooks();
}
