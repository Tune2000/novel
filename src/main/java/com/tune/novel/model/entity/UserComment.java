package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户评论(UserComment)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_comment")
public class UserComment  {
    //主键@TableId
    private Long id;

    //评论用户ID
    private Long userId;
    //评论小说ID
    private Long bookId;
    //评价内容
    private String commentContent;
    //回复数量
    private Object replyCount;
    //审核状态;0-待审核 1-审核通过 2-审核不通过
    private Integer auditStatus;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


