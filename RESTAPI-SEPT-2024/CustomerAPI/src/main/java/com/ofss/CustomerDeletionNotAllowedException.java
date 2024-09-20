package com.ofss;

public class CustomerDeletionNotAllowedException extends RuntimeException {
	public CustomerDeletionNotAllowedException(String message) {
		super(message);
	}

}
