package com.tune.novel.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户阅读历史(UserReadHistory)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_read_history")
public class UserReadHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //用户ID
    private Long userId;
    //小说ID
    private Long bookId;
    //上一次阅读的章节内容表ID
    private Long preContentId;
    //创建时间;
    private Date createTime;
    //更新时间;
    private Date updateTime;



}


