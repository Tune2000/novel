package com.tune.novel.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 小说章节(BookChapter)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_chapter")
public class BookChapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //小说ID
    private Long bookId;
    //章节号
    private Integer chapterNum;
    //章节名
    private String chapterName;
    //章节字数
    private Integer wordCount;
    //是否收费;1-收费 0-免费
    private Integer isVip;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;



}


