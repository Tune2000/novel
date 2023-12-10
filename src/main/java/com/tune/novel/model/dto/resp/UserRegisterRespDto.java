package com.tune.novel.model.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author Tune
 * @create 2023-12-10-16:51
 * @description:
 * 用户注册 响应DTO
 */
@Data
@Builder
public class UserRegisterRespDto {
    @Schema(description = "用户ID")
    private Long uid;

    @Schema(description = "用户token")
    private String token;
}
