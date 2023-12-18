package com.tune.novel.core.auth;

import com.tune.novel.core.common.constant.ApiRouterConsts;
import com.tune.novel.core.common.constant.ErrorCodeEnum;
import com.tune.novel.core.common.exception.BusinessException;
import com.tune.novel.core.utils.JwtUtils;
import com.tune.novel.manager.cache.AuthorInfoCacheManager;
import com.tune.novel.manager.cache.UserInfoCacheManager;
import com.tune.novel.model.dto.AuthorInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Tune
 * @create 2023-12-17-17:51
 * @description: 作家后台管理系统 认证授权策略
 */
@Component
@RequiredArgsConstructor
public class AuthorAuthStrategy implements AuthStrategy {

    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;

    private final AuthorInfoCacheManager authorInfoCacheManager;

    /**
     * 不需要进行作家权限认证的 URI
     */
    private static final List<String> EXCLUDE_URI = Arrays.asList(
            ApiRouterConsts.API_AUTHOR_URL_PREFIX + "/register",
            ApiRouterConsts.API_AUTHOR_URL_PREFIX + "/status"
    );

    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        // 统一账号认证
        Long userId = authSSO(jwtUtils, userInfoCacheManager, token);
        if (EXCLUDE_URI.contains(requestUri)) {
            // 该请求不需要进行作家权限认证
            return;
        }
        // 作家权限认证
        AuthorInfoDto authorInfo = authorInfoCacheManager.getAuthor(userId);
        if (Objects.isNull(authorInfo)) {
            // 作家账号不存在，无权访问作家专区
            throw new BusinessException(ErrorCodeEnum.USER_UN_AUTH);
        }

        // 设置作家ID到当前线程
        UserHolder.setAuthorId(authorInfo.getId());
    }

}