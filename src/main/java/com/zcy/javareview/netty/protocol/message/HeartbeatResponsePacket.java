package com.zcy.javareview.netty.protocol.message;


import com.zcy.javareview.netty.protocol.message.command.Command;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/28 19:14
**/
public class HeartbeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
