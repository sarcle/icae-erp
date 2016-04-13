package com.uttec.icae.exception;

public class IcaeErpException extends RuntimeException {

	private static final long serialVersionUID = -5725227719879081090L;

	public IcaeErpException() {
	}

	public IcaeErpException(String message) {
		super(message);
	}

	public IcaeErpException(Throwable cause) {
		super(cause);
	}

	public IcaeErpException(String message, Throwable cause) {
		super(message, cause);
	}

	public IcaeErpException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
