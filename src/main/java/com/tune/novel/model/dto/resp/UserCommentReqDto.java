package com.tune.novel.model.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Tune
 * @create 2023-12-16-13:33
 * @description: 用户发表评论 请求DTO
 */
@Data
public class UserCommentReqDto {

    private Long userId;

    @Schema(description = "小说ID", required = true)
    @NotNull(message="小说ID不能为空！")
    private Long bookId;

    @Schema(description = "评论内容", required = true)
    @NotBlank(message="评论不能为空！")
    @Length(min = 10,max = 512)
    private String commentContent;

}
