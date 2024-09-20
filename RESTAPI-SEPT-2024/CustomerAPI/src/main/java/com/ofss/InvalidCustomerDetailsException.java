package com.ofss;

public class InvalidCustomerDetailsException extends RuntimeException {
	public InvalidCustomerDetailsException (String message) {
		super(message);
	}
}
