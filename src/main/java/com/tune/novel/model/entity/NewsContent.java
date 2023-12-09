package com.tune.novel.model.entity;

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
public class NewsContent  {
    //主键@TableId
    private Long id;

    //新闻ID
    private Long newsId;
    //新闻内容
    private String content;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


