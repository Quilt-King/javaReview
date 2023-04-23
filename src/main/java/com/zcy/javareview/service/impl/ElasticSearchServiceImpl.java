package com.zcy.javareview.service.impl;

import com.zcy.javareview.dto.RedisData;
import com.zcy.javareview.service.ElasticSearchService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/4/6 14:45
 * @description:
 */
@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private static Logger logger = LogManager.getLogger(ElasticSearchServiceImpl.class.getName());
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void initIndex() {
        try {
            elasticsearchTemplate.indexOps(RedisData.class).create();
        } catch (Exception e) {
            logger.error("初始化索引失败", e);
        }
    }
}
