package com.tune.novel.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户消费记录(UserConsumeLog)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_consume_log")
public class UserConsumeLog implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键@TableId
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //消费用户ID
    private Long userId;
    //消费使用的金额;单位：屋币
    private Object amount;
    //消费商品类型;0-小说VIP章节
    private Integer productType;
    //消费的的商品ID;例如：章节ID
    private Long productId;
    //消费的的商品名;例如：章节名
    private String producName;
    //消费的的商品值;例如：1
    private Object producValue;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


