package com.tune.novel.model.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Tune
 * @create 2023-12-18-10:34
 * @description: 小说发布 请求DTO
 */
@Data
public class BookAddReqDto {

    /**
     * 作品方向;0-男频 1-女频
     */
    @Schema(description = "作品方向;0-男频 1-女频", required = true)
    @NotNull
    private Integer workDirection;

    /**
     * 类别ID
     */
    @Schema(description = "类别ID", required = true)
    @NotNull
    private Long categoryId;

    /**
     * 类别名
     */
    @Schema(description = "类别名", required = true)
    @NotBlank
    private String categoryName;

    /**
     * 小说封面地址
     */
    @Schema(description = "小说封面地址", required = true)
    @NotBlank
    private String picUrl;

    /**
     * 小说名
     */
    @Schema(description = "小说名", required = true)
    @NotBlank
    private String bookName;

    /**
     * 书籍描述
     */
    @Schema(description = "书籍描述", required = true)
    @NotBlank
    private String bookDesc;

    /**
     * 是否收费;1-收费 0-免费
     */
    @Schema(description = "是否收费;1-收费 0-免费", required = true)
    @NotNull
    private Integer isVip;
}
