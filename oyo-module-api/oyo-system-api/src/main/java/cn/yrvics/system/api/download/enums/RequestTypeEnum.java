package cn.yrvics.system.api.download.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求方式
 */
@Getter
@AllArgsConstructor
public enum RequestTypeEnum {

    GET(1,"get"),
    POST(2,"post"),

    ;

    private Integer code;

    private String msg;
}
