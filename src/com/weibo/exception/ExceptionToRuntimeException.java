package com.weibo.exception;

public class ExceptionToRuntimeException extends RuntimeException {

	public ExceptionToRuntimeException() {
		super();
	}

	public ExceptionToRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionToRuntimeException(String message) {
		super(message);
	}

	public ExceptionToRuntimeException(Throwable cause) {
		super(cause);
	}

}
