package cn.yrvics.system.api.download.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 进度状态
 */
@Getter
@AllArgsConstructor
public enum ScheduleStatusEnum {
    NOT_FINISH(1,"未完成"),
    FINISH(2,"已完成"),;

    private Integer code;
    private String msg;


}
