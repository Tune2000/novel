package com.tune.novel.servie;

import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.resp.ImgVerifyCodeRespDto;

import java.io.IOException;

/**
 * @author Tune
 * @create 2023-12-09-23:24
 * @description:
 * 资源（图片/视频/文档）相关服务类
 */
public interface ResourceService {
    /**
     * 获取图片验证码
     *
     * @throws IOException 验证码图片生成失败
     * @return Base64编码的图片
     */
    RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException;
}
