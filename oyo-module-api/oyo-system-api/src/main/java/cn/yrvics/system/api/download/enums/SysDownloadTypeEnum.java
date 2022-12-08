package cn.yrvics.system.api.download.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 下载类型
 */
@Getter
@AllArgsConstructor
public enum SysDownloadTypeEnum {

    EXCEL_TEMPLATE(1,"excel模板");

    private Integer code;

    private String msg;
}
