package com.tune.novel.model.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Tune
 * @create 2023-12-18-11:08
 * @description: 章节修改 请求DTO
 */
@Data
public class ChapterUpdateReqDto {

    /**
     * 章节名
     */
    @NotBlank
    @Schema(description = "章节名", required = true)
    private String chapterName;

    /**
     * 章节内容
     */
    @Schema(description = "章节内容", required = true)
    @NotBlank
    @Length(min = 50)
    private String chapterContent;

    /**
     * 是否收费;1-收费 0-免费
     */
    @Schema(description = "是否收费;1-收费 0-免费", required = true)
    @NotNull
    private Integer isVip;

}
