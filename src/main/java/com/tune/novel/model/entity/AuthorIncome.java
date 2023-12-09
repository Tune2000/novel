package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 稿费收入统计(AuthorIncome)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("author_income")
public class AuthorIncome  {
    //主键@TableId
    private Long id;

    //作家ID
    private Long authorId;
    //小说ID
    private Long bookId;
    //收入月份
    private Date incomeMonth;
    //税前收入;单位：分
    private Object preTaxIncome;
    //税后收入;单位：分
    private Object afterTaxIncome;
    //支付状态;0-待支付 1-已支付
    private Integer payStatus;
    //稿费确认状态;0-待确认 1-已确认
    private Integer confirmStatus;
    //详情
    private String detail;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


