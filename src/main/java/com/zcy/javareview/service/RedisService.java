package com.zcy.javareview.service;

import java.lang.annotation.Documented;
import org.apache.ibatis.annotations.Param;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/31 15:28
 * @description:
 */
public interface RedisService {

    /**
     * @Description: 获取redis数据
     * @author: zcy
     * @date: 2023/3/31 15:58
     * @param: value
     * @return: java.lang.String
     **/
    String get(@Param("value") String value);


    /**
     * @Description: 设置redis数据
     * @author: zcy
     * @date: 2023/3/31 15:59
     * @param: value
     * @return: java.lang.String
     **/
    String set(@Param("value") String value, @Param("key") Object key);

    String set(@Param("value") String value, @Param("key") Object key, @Param("time") Long time);
}
