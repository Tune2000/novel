package com.tune.novel.model.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 小说内容(BookContent)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_content")
public class BookContent  {
    //主键@TableId
    private Long id;

    //章节ID
    private Long chapterId;
    //小说章节内容
    private String content;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;



}


