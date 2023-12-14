package com.tune.novel.servie.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.manager.cache.VerifyCodeManager;
import com.tune.novel.model.dto.resp.ImgVerifyCodeRespDto;
import com.tune.novel.servie.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Tune
 * @create 2023-12-09-23:25
 * @description:
 * 资源（图片/视频/文档）相关服务实现类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ResourceServiceImpl implements ResourceService {

    private final VerifyCodeManager verifyCodeManager;

    @Override
    public RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException {
        String sessionId = IdWorker.get32UUID();
        return RestResp.ok(ImgVerifyCodeRespDto.builder()
                .sessionId(sessionId)
                .img(verifyCodeManager.genImgVerifyCode(sessionId))
                .build());
    }
}
