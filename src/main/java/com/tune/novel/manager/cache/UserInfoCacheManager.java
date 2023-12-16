package com.tune.novel.manager.cache;

import com.tune.novel.core.constant.CacheConsts;
import com.tune.novel.mapper.UserInfoMapper;
import com.tune.novel.model.dto.UserInfoDto;
import com.tune.novel.model.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Tune
 * @create 2023-12-16-14:33
 * @description:用户信息 缓存管理类
 */
@Component
@RequiredArgsConstructor
public class UserInfoCacheManager {

    private final UserInfoMapper userInfoMapper;

    /**
     * 查询用户信息，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER,
            value = CacheConsts.USER_INFO_CACHE_NAME)
    public UserInfoDto getUser(Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (Objects.isNull(userInfo)) {
            return null;
        }
        return UserInfoDto.builder()
                .id(userInfo.getId())
                .status(userInfo.getStatus()).build();
    }
}