package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 作者信息(AuthorInfo)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("author_info")
public class AuthorInfo  {
    //主键@TableId
    private Long id;

    //用户ID
    private Long userId;
    //邀请码
    private String inviteCode;
    //笔名
    private String penName;
    //手机号码
    private String telPhone;
    //QQ或微信账号
    private String chatAccount;
    //电子邮箱
    private String email;
    //作品方向;0-男频 1-女频
    private Integer workDirection;
    //0：正常;1-封禁
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


