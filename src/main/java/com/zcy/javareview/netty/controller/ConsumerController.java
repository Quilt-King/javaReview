package com.zcy.javareview.netty.controller;

import com.zcy.javareview.netty.client.NettyClient;
import com.zcy.javareview.netty.protocol.protobuf.MessageBase;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/28 19:10
**/
@RestController
public class ConsumerController {
    private static final Logger logger = LogManager.getLogger(ConsumerController.class.getName());

    @Autowired
    private NettyClient nettyClient;

    @GetMapping("/send")
    public String send() {
        logger.info("给服务端发送消息");
        MessageBase.Message message = new MessageBase.Message()
                .toBuilder().setCmd(MessageBase.Message.CommandType.NORMAL)
                .setContent("hello netty")
                .setRequestId(UUID.randomUUID().toString()).build();
        nettyClient.sendMsg(message);
        return "send ok";
    }
}
