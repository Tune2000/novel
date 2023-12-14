package com.tune.novel.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 新闻内容(NewsContent)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("news_content")
public class NewsContent implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键@TableId
    private Long id;

    //新闻ID
    private Long newsId;
    //新闻内容
    private String content;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;



}


