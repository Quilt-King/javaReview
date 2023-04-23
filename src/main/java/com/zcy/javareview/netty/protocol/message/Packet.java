package com.zcy.javareview.netty.protocol.message;

import lombok.Data;

/**
 * @description: 包
 * @author: zcy
 * @date: 2023/3/28 19:14
**/
@Data
public abstract class Packet {
    /**
     * 版本
     */
    private Byte version = 1;

    public abstract Byte getCommand();
}
