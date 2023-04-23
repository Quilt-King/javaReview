package com.zcy.javareview.netty.client;

import com.zcy.javareview.netty.protocol.protobuf.MessageBase;
import com.zcy.javareview.netty.server.NettyServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/28 15:48
**/
public class NettyClientHandler extends SimpleChannelInboundHandler<String > {
    private static final Logger logger = LogManager.getLogger(NettyClientHandler.class.getName());

    /**
     * 如果服务端发生消息给客户端，下面方法进行接收消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String  msg) throws Exception {
        logger.info("客户端收到消息：{}",msg);
    }

    /**
     * 处理异常, 一般将实现异常处理逻辑的Handler放在ChannelPipeline的最后
     * 这样确保所有入站消息都总是被处理，无论它们发生在什么位置，下面只是简单的关闭Channel并打印异常信息
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("客户端发生异常",cause);
        ctx.close();
    }
}
