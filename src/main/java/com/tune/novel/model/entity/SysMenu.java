package com.tune.novel.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统菜单(SysMenu)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //父菜单ID;一级菜单为0
    private Long parentId;
    //菜单名称
    private String name;
    //菜单URL
    private String url;
    //类型;0-目录   1-菜单
    private Integer type;
    //菜单图标
    private String icon;
    //排序
    private Integer sort;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;



}


