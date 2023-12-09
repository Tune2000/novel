package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 新闻信息(NewsInfo)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("news_info")
public class NewsInfo  {
    //主键@TableId
    private Long id;

    //类别ID
    private Long categoryId;
    //类别名
    private String categoryName;
    //新闻来源
    private String sourceName;
    //新闻标题
    private String title;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


