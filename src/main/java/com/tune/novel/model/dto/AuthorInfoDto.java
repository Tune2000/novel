package com.tune.novel.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Tune
 * @create 2023-12-17-16:27
 * @description:作家信息 DTO
 */
@Data
@Builder
public class AuthorInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String penName;

    private Integer status;

}