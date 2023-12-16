package com.tune.novel.core.auth;

import com.tune.novel.core.common.exception.BusinessException;
import com.tune.novel.core.utils.JwtUtils;
import com.tune.novel.manager.cache.UserInfoCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Tune
 * @create 2023-12-16-16:25
 * @description: 前台门户系统 认证授权策略
 */
@Component
@RequiredArgsConstructor
public class FrontAuthStrategy implements AuthStrategy{

    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;

    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        // 统一账号认证
        authSSO(jwtUtils, userInfoCacheManager, token);
    }
}
