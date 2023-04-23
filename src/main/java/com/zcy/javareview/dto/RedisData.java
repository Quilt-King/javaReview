package com.zcy.javareview.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/31 16:12
 * @description:
 */
@Builder
@Data
@Schema(name = "redis数据类")
public class RedisData {

    @Id
    @Field(type = FieldType.Text, index = false)
    private long id;

    @Schema(title = "键")
    @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String key;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    @Schema(title = "值")
    private Object value;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    @Schema(title = "过期时间")
    private Long time;
}
