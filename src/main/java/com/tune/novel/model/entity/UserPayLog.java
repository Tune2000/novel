package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户充值记录(UserPayLog)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_pay_log")
public class UserPayLog  {
    @TableId
    private Long id;

    //充值用户ID
    private Long userId;
    //充值方式;0-支付宝 1-微信
    private Integer payChannel;
    //商户订单号
    private String outTradeNo;
    //充值金额;单位：分
    private Object amount;
    //充值商品类型;0-屋币 1-包年VIP
    private Integer productType;
    //充值商品ID
    private Long productId;
    //充值商品名;示例值：屋币
    private String productName;
    //充值商品值;示例值：255
    private Object productValue;
    //充值时间
    private Date payTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


