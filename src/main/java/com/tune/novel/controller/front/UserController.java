package com.tune.novel.controller.front;

import com.tune.novel.core.common.constant.ApiRouterConsts;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.core.constant.SystemConfigConsts;
import com.tune.novel.model.dto.req.UserRegisterReqDto;
import com.tune.novel.model.dto.resp.UserRegisterRespDto;
import com.tune.novel.servie.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Tune
 * @create 2023-12-10-17:31
 * @description:
 * 前台门户-会员模块 API 控制器
 */
@Tag(name = "UserController", description = "前台门户-会员模块")
@SecurityRequirement(name = SystemConfigConsts.HTTP_AUTH_HEADER_NAME)
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_USER_URL_PREFIX)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 用户注册接口
     */
    @Operation(summary = "用户注册接口")
    @PostMapping("register")
    public RestResp<UserRegisterRespDto> register(@Valid @RequestBody UserRegisterReqDto dto) {
        return userService.register(dto);
    }
}
