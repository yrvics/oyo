package cn.yrvics.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * token拥有者
 */
@Getter
@AllArgsConstructor
public enum TokenOwnerTypeEnum {

    /**
     * 手机号
     */
    MOBILE,

    /**
     * 客户id
     */
    MEMBER_ID,

    /**
     * 账号
     */
    ACNO,

    /**
     * 身份证号
     */
    IDNO;

}
