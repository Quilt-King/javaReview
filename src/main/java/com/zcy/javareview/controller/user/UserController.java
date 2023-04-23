package com.zcy.javareview.controller.user;

import com.alibaba.fastjson2.JSON;
import com.zcy.javareview.entity.User;
import com.zcy.javareview.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 9:41
 * @description:
 */
@RestController
@RequestMapping("/User")
@Tag(name = "用户测试")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class.getName());
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${spring.data.redis.host}")
    private String redisIp;
    @Value("${spring.data.redis.port}")
    private String redisPort;

    @Operation(method = "获取redis配置")
    @GetMapping("/redis")
    private String getRedis() {
        logger.info("获取redisIp为：" + redisIp + ",redis端口为：" + redisPort);
        return redisIp + ":" + redisPort;
    }

    @GetMapping("/queryUser")
    @Operation(method = "查询用户")
    private User queryUser(String id) {
        logger.info("接收参数：" + id);
        User user = userService.queryUser(Integer.valueOf(id));
        logger.info("返回值为：" + user);
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("age", user.getAge());
        String jsonString = JSON.toJSONString(map);
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", jsonString);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", jsonString);
        return user;
    }

    @PostMapping("/addUser")
    @Operation(method = "增加用户")
    private int addUser(@RequestBody User user) {
        int arrow = userService.insertUser(user);
        return arrow;
    }

    /**
     * 使用 RestTemplate 进行远程服务调用，并且使用 Ribbon 进行负载均衡
     */
    @PostMapping("/test")
    @Operation(tags = "RestTemplate", description = "使用RestTemplate进行远程服务调用，并使用Ribbon进行负载均衡")
    public String getByRestTemplate(@RequestBody User user) {
        //第一个cloud-producer-server代表在nacos注册中心中的服务名，第二个cloud-producer-server代表contextPath配置的项目路径
        String url = "http://consumer-service/User/addUser";
        logger.info("使用RestTemplate进行远程服务调用，并使用Ribbon进行负载均衡"+url);
        //通过服务名的方式调用远程服务（非ip端口）
        return restTemplate.postForObject(url, user, String.class);
    }
}
