package com.tune.novel.manager.cache;

import com.tune.novel.core.common.util.ImgVerifyCodeUtils;
import com.tune.novel.core.constant.CacheConsts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

/**
 * @author Tune
 * @create 2023-12-09-23:11
 * @description:
 * 验证码 管理类
 * 保存验证码的时候需要一个全局唯一的 sessionId 字符串用于标识该验证码属于哪个浏览器会话，
 * 该 sessionId 会在验证码返回给前端的时候一并返回，在用户提交注册的时候，该 sessionId 会和验证码一起提交用于校验
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class VerifyCodeManager {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 生成图形验证码，并放入 Redis 中
     */
    public String genImgVerifyCode(String sessionId) throws IOException {
        String verifyCode = ImgVerifyCodeUtils.getRandomVerifyCode(4);
        String img = ImgVerifyCodeUtils.genVerifyCodeImg(verifyCode);
        stringRedisTemplate.opsForValue().set(CacheConsts.IMG_VERIFY_CODE_CACHE_KEY + sessionId, verifyCode, Duration.ofMinutes(5));
        return img;
    }

    /**
     * 校验图形验证码
     */
    public boolean imgVerifyCodeOk(String sessionId, String verifyCode) {
        return Objects.equals(
                stringRedisTemplate.opsForValue().get(CacheConsts.IMG_VERIFY_CODE_CACHE_KEY + sessionId)
                , verifyCode);
    }

    /**
     * 从 Redis 中删除验证码
     */
    public void removeImgVerifyCode(String sessionId) {
        stringRedisTemplate.delete(CacheConsts.IMG_VERIFY_CODE_CACHE_KEY + sessionId);
    }
}
