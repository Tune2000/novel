package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 友情链接(HomeFriendLink)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("home_friend_link")
public class HomeFriendLink  {
    @TableId
    private Long id;

    //链接名
    private String linkName;
    //链接url
    private String linkUrl;
    //排序号
    private Integer sort;
    //是否开启;0-不开启 1-开启
    private Integer isOpen;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


