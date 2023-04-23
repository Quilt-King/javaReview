package com.zcy.javareview.netty.protocol.message;

import static com.zcy.javareview.netty.protocol.message.command.Command.HEARTBEAT_REQUEST;

import lombok.Data;

/**
 * @description:
 * @author: zcy
 * @date: 2023/3/28 19:14
**/
@Data
public class HeartbeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
