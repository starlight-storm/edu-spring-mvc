package com.example.customer.common.exception;

public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException() {
	}

	public DataNotFoundException(String msg) {
		super(msg);
	}

	public DataNotFoundException(Throwable th) {
		super(th);
	}

	public DataNotFoundException(String msg, Throwable th) {
		super(msg, th);
	}

	private static final long serialVersionUID = 9046514570511590390L;
}
