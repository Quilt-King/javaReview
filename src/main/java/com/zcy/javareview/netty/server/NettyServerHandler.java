package com.zcy.javareview.netty.server;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zcy.javareview.JavaReviewApplication;
import com.zcy.javareview.netty.protocol.message.BasicMessage;
import com.zcy.javareview.netty.protocol.message.BasicReplyMessage;
import com.zcy.javareview.netty.protocol.message.HeartbeatResponsePacket;
import com.zcy.javareview.netty.protocol.protobuf.MessageBase;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/28 19:16
**/
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger logger = LogManager.getLogger(NettyServerHandler.class.getName());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String  msg) throws Exception {
        logger.info("接收客户端数据"+msg);
        ArrayList<String> strings = new ArrayList<>();
        BasicMessage basicMessage = JSONObject.parseObject(msg, BasicMessage.class);
        BasicReplyMessage basicReplyMessage = new BasicReplyMessage();
        basicReplyMessage.setTxid(basicMessage.getTxid());
        basicReplyMessage.setMethod(basicMessage.getMethod());
        basicReplyMessage.setResult("OK");
        basicReplyMessage.setErrorMessage("");
        for (int i = 0; i < 1000; i++) {
            strings.add("aaa"+i);
        }
        basicReplyMessage.setData(strings);
        String jsonString = JSON.toJSONString(basicReplyMessage);
        ctx.writeAndFlush(jsonString+";");
//        if (msg.getCmd().equals(MessageBase.Message.CommandType.HEARTBEAT_REQUEST)) {
//            logger.info("收到客户端发来的心跳消息：{}", msg.toString());
//            //回应pong
//            ctx.writeAndFlush(new HeartbeatResponsePacket());
//        } else if (msg.getCmd().equals(MessageBase.Message.CommandType.NORMAL)) {
//            logger.info("收到客户端的业务消息：{}",msg.toString());
//        }
    }
}
