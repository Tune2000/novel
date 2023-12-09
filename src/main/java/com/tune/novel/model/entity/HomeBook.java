package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 小说推荐(HomeBook)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("home_book")
public class HomeBook  {
    @TableId
    private Long id;

    //推荐类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐
    private Integer type;
    //推荐排序
    private Integer sort;
    //推荐小说ID
    private Long bookId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


