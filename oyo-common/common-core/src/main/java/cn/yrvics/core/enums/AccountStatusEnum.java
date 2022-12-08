package cn.yrvics.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账户状态
 */
@Getter
public enum AccountStatusEnum {
    /**
     * 正常
     */
    NORMAL,

    /**
     * 冻结或未激活
     */
    FROZEN,

    /**
     * 锁定
     */
    LOCKED,

    /**
     * 过期
     */
    EXPIRED;
}
