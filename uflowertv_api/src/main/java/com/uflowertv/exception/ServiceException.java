package com.uflowertv.exception;

public class ServiceException extends BaseException {
	private static final long serialVersionUID = -1637084272183912410L;

	/**
	 * Constructors
	 * 
	 * @param code
	 *            错误代码
	 */
	public ServiceException(String code) {
		super(code, null, code, null);
	}

	/**
	 * Constructors
	 * 
	 * @param cause
	 *            异常接口
	 * @param code
	 *            错误代码
	 */
	public ServiceException(Throwable cause, String code) {
		super(code, cause, code, null);
	}

	/**
	 * Constructors
	 * 
	 * @param code
	 *            错误代码
	 * @param values
	 *            一组异常信息待定参数
	 */
	public ServiceException(String code, Object[] values) {
		super(code, null, code, values);
	}

	/**
	 * Constructors
	 * 
	 * @param cause
	 *            异常接口
	 * @param code
	 *            错误代码
	 * @param values
	 *            一组异常信息待定参数
	 */
	public ServiceException(Throwable cause, String code, Object[] values) {
		super(code, null, code, values);
	}
}
