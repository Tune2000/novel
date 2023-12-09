package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 作家邀请码(AuthorCode)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:32
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("author_code")
public class AuthorCode  {
    //主键@TableId
    private Long id;

    //邀请码
    private String inviteCode;
    //有效时间
    private Date validityTime;
    //是否使用过;0-未使用 1-使用过
    private Integer isUsed;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


