/**
 * 代码生成器自动生成代码
 *  by Sjaco 394698594@qq.com
 */ 
package cn.yrvics.system.download.entity;

import cn.yrvics.system.api.download.enums.ExpireStatusEnum;
import cn.yrvics.system.api.download.enums.RequestTypeEnum;
import cn.yrvics.system.api.download.enums.SysDownLoadStatusEnum;
import cn.yrvics.system.api.download.enums.SysDownloadTypeEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "系统下载中心表")
public class SysDownload implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "下载任务标题")
    private String title;

    /**
     * @see SysDownloadTypeEnum
     */
    @ApiModelProperty(value = "任务类型")
    private Integer type;
     
    @ApiModelProperty(value = "文件路径")
    private String url;

    @ApiModelProperty(value = "请求接口路径")
    private String  requestUrl;

    /**
     * @see RequestTypeEnum
     */
    @ApiModelProperty(value = "请求方式")
    private Integer requestMethod;
     
    @ApiModelProperty(value = "创建者id")
    private Long creatorId;
     
    @ApiModelProperty(value = "创建者名称")
    private String creatorName;

    /**
     * @see SysDownLoadStatusEnum
     */
    @ApiModelProperty(value = "下载状态")
    private Integer downloadStatus;

    /**
     * @see ExpireStatusEnum
     */
    @ApiModelProperty(value = "过期状态")
    private Integer expireStatus;
     
    @ApiModelProperty(value = "请求参数json")
    private String paramJson;

    @ApiModelProperty(value = "请求条件json")
    private String requestJson;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "下载结束时间")
    private LocalDateTime endTime;
     
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;
     
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime utime;

    @ApiModelProperty(value = "模块id")
    private Long moduleId;

    @ApiModelProperty(value = "buId")
    private Long buId;

    @ApiModelProperty(value = "租户id")
    private Long tenantId;
}
