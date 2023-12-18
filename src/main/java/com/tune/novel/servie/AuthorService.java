package com.tune.novel.servie;

import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.req.AuthorRegisterReqDto;

/**
 * @author Tune
 * @create 2023-12-17-16:25
 * @description: 作家模块 业务服务类
 */
public interface AuthorService {
    /**
     * 作家注册
     *
     * @param dto 注册参数
     * @return void
     */
    RestResp<Void> register(AuthorRegisterReqDto dto);

    /**
     * 查询作家状态
     *
     * @param userId 用户ID
     * @return 作家状态
     */
    RestResp<Integer> getStatus(Long userId);
}
