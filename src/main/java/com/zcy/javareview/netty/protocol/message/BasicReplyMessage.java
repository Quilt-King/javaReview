package com.zcy.javareview.netty.protocol.message;

import java.util.List;
import lombok.Data;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/29 11:37
 * @description:
 */
@Data
public class BasicReplyMessage {
private String method;
private String txid;
private String result;
private String errorMessage;
private List data;
}
