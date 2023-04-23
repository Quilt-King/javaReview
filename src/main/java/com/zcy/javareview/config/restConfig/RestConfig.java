package com.zcy.javareview.config.restConfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/30 17:59
 * @description:
 */
@Configuration
public class RestConfig
{
    /**
     * 创建restTemplate对象。
     * LoadBalanced注解表示赋予restTemplate使用Ribbon的负载均衡的能力（一定要加上注解，否则无法远程调用）
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
