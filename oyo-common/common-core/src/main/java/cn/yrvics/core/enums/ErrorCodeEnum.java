package cn.yrvics.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    /**
     * 通用码
     */
    SUCCESS("00000", "交易接收成功"),
    ERROR("99999", "系统异常，请稍后！"),


    /**
     * 客户端异常
     */
    USER_ERROR_A0001("A0001", "客户端异常"),

    //客户端通用
    USER_ERROR_A1000("A1000", "操作成功"),
    USER_ERROR_A1001("A1001", "操作失败"),
    USER_ERROR_A1002("A1002", "查询成功"),
    USER_ERROR_A1003("A1003", "查询失败"),
    USER_ERROR_A1004("A1004", "新增成功"),
    USER_ERROR_A1005("A1005", "新增失败"),
    USER_ERROR_A1006("A1006", "更新成功"),
    USER_ERROR_A1007("A1007", "更新失败"),
    USER_ERROR_A1008("A1008", "删除成功"),
    USER_ERROR_A1009("A1009", "删除失败"),
    USER_ERROR_A1010("A1010", "步骤缺失，操作不合法"),


    //参数校验类
    USER_ERROR_A2000("A2000", "id不能为空"),


    //身份认证
    USER_ERROR_A3000("A3000", "用户登陆异常"),
    USER_ERROR_A3001("A3001", "账户不可用"),
    USER_ERROR_A3002("A3002", "账户状态异常"),
    USER_ERROR_A3003("A3003", "账户未激活"),
    USER_ERROR_A3004("A3004", "账号已被锁定"),
    USER_ERROR_A3005("A3005", "账号已过期"),
    USER_ERROR_A3006("A3006", "尚未登录或登录状态已过期"),




    //文件资源类
    USER_ERROR_A5000("A0400", "用户文件不存在"),
    USER_ERROR_A5001("A0401", "用户文件存在缺失"),
    USER_ERROR_A5002("A0402", "文件上传失败，请检查系统配置"),
    USER_ERROR_A5003("A0403", "不支持该文件存储方式"),
    USER_ERROR_A5004("A0404", "用户上传视频太大"),
    USER_ERROR_A5005("A0405", "用户上传压缩文件太大"),
    USER_ERROR_A5006("A0406", "用户文件不存在"),
    USER_ERROR_A5007("A0407", "用户文件存在缺失"),
    USER_ERROR_A5008("A0408", "不支持该文件存储方式"),
    USER_ERROR_A5009("A0409", "文件上传失败，请检查系统配置"),


    //业务类
    USER_ERROR_A6000("A6000", "品牌已存在"),
    USER_ERROR_A6001("A6001", "品牌不存在"),
    USER_ERROR_A6002("A6002", "相同商品已存在"),
    USER_ERROR_A6003("A6003", "库存不足"),
    USER_ERROR_A6004("A6004", "商品sku不存在"),
    USER_ERROR_A6005("A6005", "相同商品已存在"),
    USER_ERROR_A6006("A6006", "发送红包失败"),
    USER_ERROR_A6007("A6007", "该支付订单红包已发送过"),
    USER_ERROR_A6008("A6008", "用户不一致"),
    USER_ERROR_A6009("A6009", "红包已领完"),
    USER_ERROR_A6010("A6010", "红包已领过"),
    USER_ERROR_A6011("A6011", "红包已过期"),
    USER_ERROR_A6012("A6012", "用户角色已存在"),
    USER_ERROR_A6013("A6013", "用户角色不存在"),
    USER_ERROR_A6014("A6014", "API已存在"),
    USER_ERROR_A6015("A6015", "API不存在"),
    USER_ERROR_A6016("A6016", "菜单重定向不能为空"),
    USER_ERROR_A6017("A6017", "父级菜单不能为空"),
    USER_ERROR_A6018("A6018", "菜单已存在"),
    USER_ERROR_A6019("A6019", "菜单不存在"),
    USER_ERROR_A6020("A6020", "存在下级子菜单，不允许删除"),
    USER_ERROR_A6021("A6021", "短信发送间隔时间过短"),
    USER_ERROR_A6022("A6022", "验证码获取次数已超限，请明日再试"),
    USER_ERROR_A6023("A6023", "超过当天发送最大次数"),
    USER_ERROR_A6024("A6024", "请先获取短信验证码"),
    USER_ERROR_A6025("A6025", "超过短信验证码验证时间"),
    USER_ERROR_A6026("A6026", "超过短信验证码验证次数"),
    USER_ERROR_A6027("A6027", "验证码错误，请重新输入"),
    USER_ERROR_A6028("A6028", "下载任务为空"),





    /**
     * 服务器异常
     */
    SYSTEM_ERROR_B0001("B0001", "服务器异常"),
    SYSTEM_ERROR_B1001("B0100", "系统执行超时"),
    SYSTEM_ERROR_B1002("B0101", "系统订单处理超时"),
    SYSTEM_ERROR_B1003("B0200", "系统容灾功能被触发"),
    SYSTEM_ERROR_B1004("B0210", "系统限流"),
    SYSTEM_ERROR_B1005("B0220", "系统功能降级"),



    /**
     * 远程调用异常
     */
    SERVICE_ERROR_C0001("C0001", "远程调用异常"),
    SERVICE_ERROR_C1001("C0100", "中间件服务出错"),
    SERVICE_ERROR_C1002("C0110", "RPC服务出错"),
    SERVICE_ERROR_C1003("C0111", "RPC服务未找到"),
    SERVICE_ERROR_C1004("C0112", "RPC服务未注册"),
    SERVICE_ERROR_C1005("C0113", "接口不存在"),
    SERVICE_ERROR_C1006("C0120", "消息服务出错"),
    SERVICE_ERROR_C1007("C0121", "消息投递出错"),
    SERVICE_ERROR_C1008("C0122", "消息消费出错"),
    SERVICE_ERROR_C1009("C0123", "消息订阅出错"),
    SERVICE_ERROR_C1010("C0124", "消息分组未查到"),
    SERVICE_ERROR_C1011("C0130", "缓存服务出错"),
    SERVICE_ERROR_C1012("C0133", "存储容量已满"),
    SERVICE_ERROR_C1013("C0134", "不支持的数据格式"),
    SERVICE_ERROR_C1014("C0140", "配置服务出错"),
    SERVICE_ERROR_C1015("C0150", "网络资源服务出错"),
    SERVICE_ERROR_C1016("C0151", "VPN服务出错"),
    SERVICE_ERROR_C1017("C0152", "CDN服务出错"),
    SERVICE_ERROR_C1018("C0153", "域名解析服务出错"),
    SERVICE_ERROR_C1019("C0154", "网关服务出错"),
    SERVICE_ERROR_C1020("C0200", "第三方系统执行超时"),
    SERVICE_ERROR_C1021("C0210", "RPC执行超时"),
    SERVICE_ERROR_C1022("C0220", "消息投递超时"),
    SERVICE_ERROR_C1023("C0230", "缓存服务超时"),
    SERVICE_ERROR_C1024("C0240", "配置服务超时"),
    SERVICE_ERROR_C1025("C0250", "数据库服务超时"),
    SERVICE_ERROR_C1026("C0300", "数据库服务出错"),
    SERVICE_ERROR_C1027("C0311", "表不存在"),
    SERVICE_ERROR_C1028("C0312", "列不存在"),
    SERVICE_ERROR_C1029("C0321", "多表关联中存在多个相同名称的列"),
    SERVICE_ERROR_C1030("C0331", "数据库死锁"),
    SERVICE_ERROR_C1031("C0341", "主键冲突"),
    SERVICE_ERROR_C1032("C0400", "第三方容灾系统被触发"),
    SERVICE_ERROR_C1033("C0401", "第三方系统限流"),
    SERVICE_ERROR_C1034("C0402", "第三方功能降级"),
    SERVICE_ERROR_C1035("C0500", "通知服务出错"),
    SERVICE_ERROR_C1036("C0501", "短信提醒服务失败"),
    SERVICE_ERROR_C1037("C0502", "语音提醒服务失败"),
    SERVICE_ERROR_C1038("C0503", "邮件提醒服务失败");

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误描述
     */
    private final String description;


}
