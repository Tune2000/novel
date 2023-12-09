package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 小说信息(BookInfo)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_info")
public class BookInfo  {
    //主键@TableId
    private Long id;

    //作品方向;0-男频 1-女频
    private Integer workDirection;
    //类别ID
    private Long categoryId;
    //类别名
    private String categoryName;
    //小说封面地址
    private String picUrl;
    //小说名
    private String bookName;
    //作家id
    private Long authorId;
    //作家名
    private String authorName;
    //书籍描述
    private String bookDesc;
    //评分;总分:10 ，真实评分 = score/10
    private Integer score;
    //书籍状态;0-连载中 1-已完结
    private Integer bookStatus;
    //点击量
    private Long visitCount;
    //总字数
    private Object wordCount;
    //评论数
    private Object commentCount;
    //最新章节ID
    private Long lastChapterId;
    //最新章节名
    private String lastChapterName;
    //最新章节更新时间
    private Date lastChapterUpdateTime;
    //是否收费;1-收费 0-免费
    private Integer isVip;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


