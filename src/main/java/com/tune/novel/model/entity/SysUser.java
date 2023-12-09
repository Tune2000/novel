package com.tune.novel.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统用户(SysUser)表实体类
 *
 * @author Tune
 * @since 2023-12-09 15:31:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUser  {
    @TableId
    private Long id;

    //用户名
    private String username;
    //密码
    private String password;
    //真实姓名
    private String name;
    //性别;0-男 1-女
    private Integer sex;
    //出身日期
    private Date birth;
    //邮箱
    private String email;
    //手机号
    private String mobile;
    //状态;0-禁用 1-正常
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



}


