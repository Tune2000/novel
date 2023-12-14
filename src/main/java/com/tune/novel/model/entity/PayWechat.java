package com.tune.novel.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 微信支付(PayWechat)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pay_wechat")
public class PayWechat implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //商户订单号
    private String outTradeNo;
    //微信支付订单号
    private String transactionId;
    //交易类型;JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付 MICROPAY-付款码支付 MWEB-H5支付 FACEPAY-刷脸支付
    private String tradeType;
    //交易状态;SUCCESS-支付成功 REFUND-转入退款 NOTPAY-未支付 CLOSED-已关闭 REVOKED-已撤销（付款码支付） USERPAYING-用户支付中（付款码支付） PAYERROR-支付失败(其他原因，如银行返回失败)
    private String tradeState;
    //交易状态描述
    private String tradeStateDesc;
    //订单总金额;单位：分
    private Integer amount;
    //用户支付金额;单位：分
    private Integer payerTotal;
    //支付完成时间
    private LocalDateTime successTime;
    //支付者用户标识;用户在直连商户appid下的唯一标识
    private String payerOpenid;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;



}


