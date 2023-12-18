package com.tune.novel.controller.author;

import com.tune.novel.core.auth.UserHolder;
import com.tune.novel.core.common.constant.ApiRouterConsts;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.core.constant.SystemConfigConsts;
import com.tune.novel.model.dto.req.AuthorRegisterReqDto;
import com.tune.novel.servie.AuthorService;
import com.tune.novel.servie.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Tune
 * @create 2023-12-17-16:14
 * @description:作家后台-作家模块 API 控制器
 */
@Tag(name = "AuthorController", description = "作家后台-作者模块")
@SecurityRequirement(name = SystemConfigConsts.HTTP_AUTH_HEADER_NAME)
@RestController
@RequestMapping(ApiRouterConsts.API_AUTHOR_URL_PREFIX)
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    /**
     * 作家注册接口
     */
    @Operation(summary = "作家注册接口")
    @PostMapping("register")
    public RestResp<Void> register(@Valid @RequestBody AuthorRegisterReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return authorService.register(dto);
    }

    /**
     * 查询作家状态接口
     */
    @Operation(summary = "作家状态查询接口")
    @GetMapping("status")
    public RestResp<Integer> getStatus() {
        return authorService.getStatus(UserHolder.getUserId());
    }


}
