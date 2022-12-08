package cn.yrvics.system.api.download.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 过期状态
 */
@Getter
@AllArgsConstructor
public enum ExpireStatusEnum {
    not_expire(1,"未过期"),
    expire(2,"已过期"),;

    private Integer code;
    private String msg;


}
