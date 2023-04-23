package com.zcy.javareview.config.rabbitmq;

import java.util.logging.Logger;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 17:46
 * @description:
 */
@Configuration
public class RabbitConfig {

    private static final Logger logger = Logger.getLogger(RabbitConfig.class.getName());

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            logger.info("ConfirmCallback:     " + "相关数据：" + correlationData);
            logger.info("ConfirmCallback:     " + "确认情况：" + ack);
            logger.info("ConfirmCallback:     " + "原因：" + cause);
        });
        rabbitTemplate.setReturnsCallback((returnedMessage) -> {
            logger.info("ReturnCallback:     " + "消息：" + returnedMessage);
        });
        return rabbitTemplate;
    }

}
