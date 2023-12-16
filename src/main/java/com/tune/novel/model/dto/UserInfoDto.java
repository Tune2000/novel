package com.tune.novel.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Tune
 * @create 2023-12-16-14:34
 * @description: 用户信息 DTO
 */
@Data
@Builder
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer status;

}