package com.zcy.javareview.netty.protocol.message;

import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/29 11:37
 * @description:
 */
@Data
public class BasicMessage {
private String method;
private String eqpCode;
private String txid;
private List<Map> data;
}
