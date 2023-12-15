package com.tune.novel.servie.impl;

import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.manager.cache.FriendLinkCacheManager;
import com.tune.novel.manager.cache.HomeBookCacheManager;
import com.tune.novel.model.dto.resp.HomeBookRespDto;
import com.tune.novel.model.dto.resp.HomeFriendLinkRespDto;
import com.tune.novel.servie.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tune
 * @create 2023-12-09-15:48
 * @description: 首页模块 服务实现类
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    private final FriendLinkCacheManager friendLinkCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {

        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }

    @Override
    public RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks() {
        return RestResp.ok(friendLinkCacheManager.listFriendLinks());
    }
}
