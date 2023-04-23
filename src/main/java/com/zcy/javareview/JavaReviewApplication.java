package com.zcy.javareview;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/21 19:52
**/
@SpringBootApplication()
@EnableDiscoveryClient
public class JavaReviewApplication {
    private static final Logger logger = LogManager.getLogger(JavaReviewApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(JavaReviewApplication.class, args);
        logger.info("程序启动成功");
    }
}
