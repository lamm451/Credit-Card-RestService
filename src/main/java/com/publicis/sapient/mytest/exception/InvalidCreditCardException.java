package com.publicis.sapient.mytest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidCreditCardException  extends RuntimeException {
	
	private static final long serialVersionUID = -6041204991952548691L;

	public InvalidCreditCardException(String message) {
		super(message);
	}

}
