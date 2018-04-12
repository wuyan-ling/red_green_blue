package com.bst.red_green_blue.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author summer
 * @version 1.0.0
 */
public class TokenCache {
    public final String toke_frefix = "toke_";
    public final String code_toke_frefix = "Code_toke_";
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);
    //LRU算法
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(5, TimeUnit.MINUTES)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }

    public static String getKey(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            } else {
                return value;
            }
        } catch (Exception e) {
            logger.error("localCache  get error", e);
        }
        return null;
    }
}
