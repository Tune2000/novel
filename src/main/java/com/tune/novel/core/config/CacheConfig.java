package com.tune.novel.core.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.tune.novel.core.constant.CacheConsts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tune
 * @create 2023-12-08-10:41
 * @description:
 * 缓存配置类
 */
@Configuration
public class CacheConfig {

    /**
     * Caffeine 缓存管理器
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        // 创建一个简单的缓存管理器
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        // 创建一个空的缓存列表
        List<CaffeineCache> caches = new ArrayList<>(CacheConsts.CacheEnum.values().length);
        for (CacheConsts.CacheEnum c : CacheConsts.CacheEnum.values()) {
            // 如果缓存是本地的
            if (c.isLocal()) {
                // 创建Caffeine缓存构建器，配置缓存的最大大小和过期时间
                Caffeine<Object, Object> caffeine = Caffeine.newBuilder().recordStats().maximumSize(c.getMaxSize());
                if (c.getTtl() > 0) {
                    caffeine.expireAfterWrite(Duration.ofSeconds(c.getTtl()));
                }
                // 将Caffeine缓存添加到缓存列表中
                caches.add(new CaffeineCache(c.getName(), caffeine.build()));
            }
        }
        // 将缓存列表设置到缓存管理器中
        cacheManager.setCaches(caches);

        // 返回创建的Caffeine缓存管理器
        return cacheManager;
    }

    /**
     * Redis 缓存管理器
     */

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 创建 Redis 单机配置
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        config.setPassword(RedisPassword.of(password));

        // 使用 Lettuce 连接工厂
        LettuceConnectionFactory factory = new LettuceConnectionFactory(config);

        // 手动触发连接工厂的属性设置方法，确保连接工厂的属性被正确配置
        factory.afterPropertiesSet();

        // 返回配置好的 Redis 连接工厂实例
        return factory;
    }

    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        // 创建非阻塞的Redis缓存写入器
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        // 配置默认的缓存配置，禁用对空值的缓存，并在缓存名称前添加前缀
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues().prefixCacheNameWith(CacheConsts.REDIS_CACHE_PREFIX);

        // 创建一个映射以保存每个缓存的特定配置
        Map<String, RedisCacheConfiguration> cacheMap = new LinkedHashMap<>(CacheConsts.CacheEnum.values().length);
        // 遍历缓存类型的枚举值
        for (CacheConsts.CacheEnum c : CacheConsts.CacheEnum.values()) {
            // 如果缓存是远程的
            if (c.isRemote()) {
                // 如果设置了TTL（Time To Live），则配置相应的缓存
                if (c.getTtl() > 0) {
                    cacheMap.put(c.getName(), RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
                            .prefixCacheNameWith(CacheConsts.REDIS_CACHE_PREFIX).entryTtl(Duration.ofSeconds(c.getTtl())));
                } else {
                    // 否则，使用默认的缓存配置
                    cacheMap.put(c.getName(), RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
                            .prefixCacheNameWith(CacheConsts.REDIS_CACHE_PREFIX));
                }
            }
        }
        // 创建Redis缓存管理器，并传入写入器、默认缓存配置和缓存配置映射
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig, cacheMap);

        // 设置事务感知，使得缓存操作能够参与到事务中
        redisCacheManager.setTransactionAware(true);

        // 初始化缓存
        redisCacheManager.initializeCaches();

        // 返回创建的Redis缓存管理器
        return redisCacheManager;
    }

}
