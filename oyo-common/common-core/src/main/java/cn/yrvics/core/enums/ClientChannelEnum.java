package cn.yrvics.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientChannelEnum {
    /**
     * 后管端
     */
    ADMIN_CLIENT,

    /**
     * 门户端
     */
    PROTAL_CLIENT;
}
