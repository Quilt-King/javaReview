package com.zcy.javareview.repository;

import com.zcy.javareview.dto.RedisData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/4/6 14:35
 * @description:
 */
public interface Repository extends ElasticsearchRepository<RedisData,Long> {
    RedisData findByKey(String key);
}
