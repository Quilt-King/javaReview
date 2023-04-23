package com.zcy.javareview.config.rabbitmq.direct;

import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 17:34
 * @description:
 */
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage);
    }

}
