package com.tune.novel.model.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author Tune
 * @create 2023-12-09-23:33
 * @description:
 * 图像验证码 响应DTO
 */
@Data
@Builder
public class ImgVerifyCodeRespDto {
    /**
     * 当前会话ID，用于标识改图形验证码属于哪个会话
     * */
    @Schema(description = "sessionId")
    private String sessionId;

    /**
     * Base64 编码的验证码图片
     * */
    @Schema(description = "Base64 编码的验证码图片")
    private String img;
}
