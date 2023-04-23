package com.zcy.javareview.config.rabbitmq.topic;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;
/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 17:37
 * @description:
 */

@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @RabbitHandler
    public void process(String  testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage);
    }
}
