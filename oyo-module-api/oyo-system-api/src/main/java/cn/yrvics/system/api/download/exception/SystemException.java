package cn.yrvics.system.api.download.exception;

import cn.yrvics.core.enums.ErrorCodeEnum;

/**
 * 返回统一异常
 * @Author YRVICS
 */
public class SystemException extends RuntimeException{


	/**
	 * 错误码
	 */
	private String errorCode;

	/**
	 * 错误信息构造
	 * @param msg
	 */
	public SystemException(String msg) {
		super(msg);
		this.errorCode = ErrorCodeEnum.ERROR.getCode();
	}

	/**
	 * 枚举构造
	 * @param ErrorCodeEnum
	 */
	public SystemException(ErrorCodeEnum ErrorCodeEnum) {
		super(ErrorCodeEnum.getDescription());
		this.errorCode = ErrorCodeEnum.getCode();
	}

	/**
	 * 获取错误码
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
