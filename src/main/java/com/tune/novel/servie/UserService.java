package com.tune.novel.servie;

import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.req.UserLoginReqDto;
import com.tune.novel.model.dto.req.UserRegisterReqDto;
import com.tune.novel.model.dto.resp.UserLoginRespDto;
import com.tune.novel.model.dto.resp.UserRegisterRespDto;

/**
 * @author Tune
 * @create 2023-12-10-16:52
 * @description:
 * 会员模块 服务类
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param dto 注册参数
     * @return JWT
     */
    RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto);

    /**
     * 用户登录
     *
     * @param dto 登录参数
     * @return JWT + 昵称
     */
    RestResp<UserLoginRespDto> login(UserLoginReqDto dto);
}
