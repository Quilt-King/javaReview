package com.zcy.javareview.netty.server;

import com.zcy.javareview.netty.protocol.protobuf.MessageBase;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/28 15:48
 **/
public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {

    private static final Logger logger = LogManager.getLogger(NettyServerHandlerInitializer.class.getName());

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer(";".getBytes(StandardCharsets.UTF_8));
        ch.pipeline()
                //空闲检测
                .addLast(new ServerIdleStateHandler())
                // 设置分隔符解码器
                .addLast(new DelimiterBasedFrameDecoder(2048, delimiter))
                .addLast(new StringDecoder(CharsetUtil.UTF_8))
                .addLast(new StringEncoder(CharsetUtil.UTF_8))
                .addLast(new NettyServerHandler());
        logger.info("服务端初始化完成");
    }
}
