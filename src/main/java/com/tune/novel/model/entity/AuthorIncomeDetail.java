package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 稿费收入明细统计(AuthorIncomeDetail)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("author_income_detail")
public class AuthorIncomeDetail  {
    //主键@TableId
    private Long id;

    //作家ID
    private Long authorId;
    //小说ID;0表示全部作品
    private Long bookId;
    //收入日期
    private Date incomeDate;
    //订阅总额
    private Object incomeAccount;
    //订阅次数
    private Object incomeCount;
    //订阅人数
    private Object incomeNumber;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


