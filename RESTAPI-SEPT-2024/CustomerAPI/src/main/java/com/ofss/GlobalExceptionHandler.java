package com.ofss;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
		// User defined method
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	    
	    // If you want to handle another exception, add another method here
	    // For example, if you want to handle NullPointerException
	    @ExceptionHandler(NullPointerException.class) 
		public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    
	    @ExceptionHandler(CustomerDeletionNotAllowedException.class)
		public ResponseEntity<String> handleCustomerDeletionNotAllowedException(
				CustomerDeletionNotAllowedException ex) {
			System.out.println("CustomerDeletionNotAllowedException occured: " + ex.getMessage());
			System.out.println("Check if the customer id exists or not before sending the request");
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		}
	    
	    @ExceptionHandler(InvalidCustomerDetailsException.class)
	    public ResponseEntity<String> handleInvalidCustomerDetailsException(InvalidCustomerDetailsException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

}

