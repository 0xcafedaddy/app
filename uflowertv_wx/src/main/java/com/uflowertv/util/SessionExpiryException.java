package com.uflowertv.util;


public class SessionExpiryException extends RuntimeException{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 1L;

	public SessionExpiryException() {
		super();
	}

	public SessionExpiryException(String message, Throwable cause) {
		super(message, cause);
	}

	public SessionExpiryException(String message) {
		super(message);
	}

	public SessionExpiryException(Throwable cause) {
		super(cause);
	}

	
}
