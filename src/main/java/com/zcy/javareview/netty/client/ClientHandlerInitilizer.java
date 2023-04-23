package com.zcy.javareview.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @description: netty客户端初始化
 * @author: zcy
 * @date: 2023/3/28 15:36
**/
public class ClientHandlerInitilizer extends ChannelInitializer<Channel> {
    private static final Logger logger = LogManager.getLogger(ClientHandlerInitilizer.class.getName());

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer(";".getBytes(StandardCharsets.UTF_8));
        ch.pipeline()
                .addLast(new DelimiterBasedFrameDecoder(1024, delimiter))
                .addLast(new IdleStateHandler(0, 10, 0))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new HeartbeatHandler())
                .addLast(new NettyClientHandler());
        logger.info("客户端初始化完成");
    }
}
