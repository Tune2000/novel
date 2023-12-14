package com.tune.novel.manager.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tune.novel.core.constant.DatabaseConsts;
import com.tune.novel.mapper.UserInfoMapper;
import com.tune.novel.model.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Tune
 * @create 2023-12-13-23:10
 * @description: 用户模块 DAO管理类
 */
@Component
@RequiredArgsConstructor
public class UserDaoManager {

    private final UserInfoMapper userInfoMapper;

    /**
     * 根据用户ID集合批量查询用户信息列表
     *
     * @param userIds 需要查询的用户ID集合
     * @return 满足条件的用户信息列表
     */
    public List<UserInfo> listUsers(List<Long> userIds) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(DatabaseConsts.CommonColumnEnum.ID.getName(), userIds);
        return userInfoMapper.selectList(queryWrapper);
    }
}
