package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 支付宝支付(PayAlipay)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pay_alipay")
public class PayAlipay  {
    //主键@TableId
    private Long id;

    //商户订单号
    private String outTradeNo;
    //支付宝交易号
    private String tradeNo;
    //买家支付宝账号 ID
    private String buyerId;
    //交易状态;TRADE_SUCCESS-交易成功
    private String tradeStatus;
    //订单金额;单位：分
    private Object totalAmount;
    //实收金额;单位：分
    private Object receiptAmount;
    //开票金额
    private Object invoiceAmount;
    //交易创建时间
    private Date gmtCreate;
    //交易付款时间
    private Date gmtPayment;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


