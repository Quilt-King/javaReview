package com.zcy.javareview.controller.redis;

import com.zcy.javareview.dto.RedisData;
import com.zcy.javareview.service.RedisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/31 15:11
 * @description:
 */
@RestController
@Tag(name = "redis测试")
@RequestMapping("/redis")
public class RedisController {

    private static final Logger logger = LogManager.getLogger(RedisController.class.getName());

    @Autowired
    RedisService redisService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/getData")
    @Operation(description = "获取redis数据")
    public String getData(String key) {
        logger.info("redis数据查询请求" + key);
        String result = redisService.get(key);
        if (result == null) {
            logger.info("未查询到数据");
        }
        rabbitTemplate.convertAndSend("TestDirectExchange",result);
        return result;
    }

    @PostMapping("/addData")
    @Operation(description = "增加redis数据")
    public String addData(@RequestBody RedisData redisData) {
        logger.info("redis设置参数请求" + redisData);
        rabbitTemplate.convertAndSend("TestDirectExchange",redisData);
        return redisService.set(redisData.getKey(), redisData.getValue(), redisData.getTime());
    }
}
