package com.zcy.javareview.service.impl;

import com.zcy.javareview.component.utils.redis.RedisTemplateUtil;
import com.zcy.javareview.service.RedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/31 15:28
 * @description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger logger = LogManager.getLogger(RedisServiceImpl.class.getName());

    @Autowired
    RedisTemplateUtil redisTemplateUtil;

    @Override
    public String get(String value) {
        Object o = redisTemplateUtil.get(value);
        if (o == null) {
            return null;
        }
        return o.toString();
    }

    @Override
    public String set(String value, Object key) {
        boolean set = redisTemplateUtil.set(value, key);
        if (!set) {
            logger.info("数据" + key + "保存失败");
        }
        return "保存成功";
    }

    @Override
    public String set(String value, Object key, Long time) {
        boolean set = redisTemplateUtil.set(value, key, time);
        if (!set) {
            logger.info("数据" + key + "保存失败");
        }
        logger.info("数据" + key + "保存成功");
        return "保存成功";
    }
}
