package com.tune.novel.model.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Tune
 * @create 2023-12-10-22:09
 * @description:
 */
@Data
public class UserLoginReqDto {
    @Schema(description = "手机号", required = true, example = "18888888888")
    @NotBlank(message = "手机号不能为空！")
    @Pattern(regexp = "^1[3|4|5|6|7|8|9][0-9]{9}$", message = "手机号格式不正确！")
    private String username;

    @Schema(description = "密码", required = true, example = "123456")
    @NotBlank(message = "密码不能为空！")
    private String password;
}
