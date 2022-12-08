package cn.yrvics.core.factory;

import cn.yrvics.core.entity.Result;
import cn.yrvics.core.enums.ErrorCodeEnum;

/**
 * 响应结果工厂
 * 统一API接口返回信息
 * @Author YRVICS
 */
public class ResultFactory {

    /**
     * 私有构造方法
     */
    private ResultFactory(){}

    /**
     * 成功返回
     * @return
     */
    public static Result<Void> ok(){
        return new Result<Void>()
                .setReturnCode(ErrorCodeEnum.SUCCESS.getCode())
                .setReturnMsg(ErrorCodeEnum.SUCCESS.getDescription());
    }

    /**
     * 成功返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data){
        return new Result<T>()
                .setReturnCode(ErrorCodeEnum.SUCCESS.getCode())
                .setReturnMsg(ErrorCodeEnum.SUCCESS.getDescription())
                .setData(data);
    }

    /**
     * 失败返回
     * @return
     */
    public static Result<Void> failure(){
        return new Result<Void>()
                .setReturnCode(ErrorCodeEnum.ERROR.getCode())
                .setReturnMsg(ErrorCodeEnum.ERROR.getDescription());
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static Result<Void> failure(String message){
        return new Result<Void>()
                .setReturnCode(ErrorCodeEnum.ERROR.getCode())
                .setReturnMsg(message);
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static Result<Void> failure(String code,String message){
        return new Result<Void>()
                .setReturnCode(code)
                .setReturnMsg(message);
    }

    /**
     * 失败返回
     * @param resultCode
     * @return
     */
    public static Result<Void> failure(ErrorCodeEnum resultCode){
        return new Result<Void>()
                .setReturnCode(resultCode.getCode())
                .setReturnMsg(resultCode.getDescription());
    }
}
