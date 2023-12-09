package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 小说类别(BookCategory)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_category")
public class BookCategory  {
    @TableId
    private Long id;

    //作品方向;0-男频 1-女频
    private Integer workDirection;
    //类别名
    private String name;
    //排序
    private Integer sort;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


