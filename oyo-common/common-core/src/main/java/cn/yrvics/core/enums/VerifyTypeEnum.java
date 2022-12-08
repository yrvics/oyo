package cn.yrvics.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * token验证类型
 */
@Getter
@AllArgsConstructor
public enum VerifyTypeEnum {
    /**
     * 短信验证码
     */
    SMS,

    /**
     * 密码
     */
    PASSWORD,

    /**
     * 滑动验证码
     */
    SLIDECODE,

    /**
     * 人脸
     */
    FACE;
}
