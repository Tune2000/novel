package com.tune.novel.model.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.checkerframework.checker.units.qual.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Tune
 * @create 2023-12-10-16:54
 * @description:
 * 用户注册 请求DTO
 */
@Data
public class UserRegisterReqDto {
    @Schema(description = "手机号", required = true)
    @NotBlank(message="手机号不能为空！")
    @Pattern(regexp="^1[3|4|5|6|7|8|9][0-9]{9}$",message="手机号格式不正确！")
    private String username;

    @Schema(description = "密码", required = true)
    @NotBlank(message="密码不能为空！")
    private String password;

    @Schema(description = "验证码", required = true)
    @NotBlank(message="验证码不能为空！")
    @Pattern(regexp="^\\d{4}$",message="验证码格式不正确！")
    private String velCode;

    /**
     * 请求会话标识，用来标识图形验证码属于哪个会话
     * */
    @Schema(description = "sessionId", required = true)
    @NotBlank
    @Size(min = 32, max = 32, message = "sessionId长度必须为32")
    private String sessionId;
}
