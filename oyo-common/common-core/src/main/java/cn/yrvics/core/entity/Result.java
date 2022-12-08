package cn.yrvics.core.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author YRVICS
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    /**
     * 结果码
     */
    private String returnCode;

    /**
     * 结果返回信息
     */
    private String returnMsg;

    /**
     * 数据
     * 为null不序列化
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

}
