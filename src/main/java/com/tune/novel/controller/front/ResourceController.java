package com.tune.novel.controller.front;

import com.tune.novel.core.common.constant.ApiRouterConsts;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.resp.ImgVerifyCodeRespDto;
import com.tune.novel.servie.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Tune
 * @create 2023-12-09-23:23
 * @description:
 * 前台门户-资源(图片/视频/文档)模块 API 控制器
 */
@Tag(name = "ResourceController", description = "前台门户-资源模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_RESOURCE_URL_PREFIX)
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;
    /**
     * 获取图片验证码接口
     */
    @Operation(summary = "获取图片验证码接口")
    @GetMapping("img_verify_code")
    public RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException {
        return resourceService.getImgVerifyCode();
    }
}
