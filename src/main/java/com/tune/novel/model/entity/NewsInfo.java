package com.tune.novel.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class NewsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;



}


