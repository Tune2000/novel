package com.tune.novel.model.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author Tune
 * @create 2023-12-18-11:06
 * @description: 小说内容 响应DTO
 */
@Data
@Builder
public class ChapterContentRespDto {

    /**
     * 章节标题
     */
    @Schema(description = "章节名")
    private String chapterName;

    /**
     * 章节内容
     */
    @Schema(description = "章节内容")
    private String chapterContent;

    /**
     * 是否收费;1-收费 0-免费
     */
    @Schema(description = "是否收费;1-收费 0-免费")
    private Integer isVip;

}