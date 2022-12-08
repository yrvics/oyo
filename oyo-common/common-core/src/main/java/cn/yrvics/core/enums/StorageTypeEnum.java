package cn.yrvics.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 存储系统类型枚举
 */
@Getter
@AllArgsConstructor
public enum StorageTypeEnum {

    /**
     * 本地存储
     */
    LOCAL_STORAGE,

    /**
     * 七牛云存储
     */
    QINIU_STORAGE;


//    private String code;
//
//    private String desc;

    /**
     * 根据枚举code获取枚举
     * @param code
     * @return
     */
//    public static StorageTypeEnum getEnumByCode(String code){
//        for (StorageTypeEnum item : StorageTypeEnum.values()){
//            if(item.getCode().equals(code)){
//                return item;
//            }
//        }
//        return null;
//    }
}
