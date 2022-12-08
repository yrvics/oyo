package cn.yrvics.system.api.download.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 下载中心下载状态枚举
 */
@Getter
@AllArgsConstructor
public enum SysDownLoadStatusEnum {
    DOWNLOAD_WAIT(1,"等待下载"),
    DOWNLOADING(2,"下载中"),
    DOWNLOAD_FINISH(3, "下载完成"),
    DOWNLOAD_FAILD(4,"下载失败"),;

    public   static final List<Integer> NOT_FINISH = Arrays.asList(DOWNLOAD_WAIT.getCode(),DOWNLOADING.getCode(),DOWNLOAD_FAILD.getCode());

    private Integer code;
    private String msg;


}
