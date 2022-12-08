package cn.yrvics.system.api.download.exception;

import cn.yrvics.core.entity.Result;
import cn.yrvics.core.enums.ErrorCodeEnum;
import cn.yrvics.core.factory.ResultFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义错误处理器
 * @Author YRVICS
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 方法参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        e.printStackTrace();
        return ResultFactory.failure(ErrorCodeEnum.USER_ERROR_A0001.getCode(),e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    /**
     * 系统自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(SystemException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> systemExceptionHandler(SystemException e){
        e.printStackTrace();
        return ResultFactory.failure(e.getErrorCode(),e.getMessage());
    }


    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Void> exceptionHandler(Exception e){
        e.printStackTrace();
        return ResultFactory.failure(ErrorCodeEnum.ERROR);
    }
}