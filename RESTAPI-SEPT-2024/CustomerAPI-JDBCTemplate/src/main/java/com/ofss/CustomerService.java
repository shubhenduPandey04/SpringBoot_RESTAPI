package com.ofss;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// View layer
// in REST API, the service layer is responsible for creating the dataset
@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDao;

	public CustomerService() {
		
	}

	public ResponseEntity<?> insertCustomer(Customer newCustomer) {
		return customerDao.insertCustomer(newCustomer);
	}

	
}
