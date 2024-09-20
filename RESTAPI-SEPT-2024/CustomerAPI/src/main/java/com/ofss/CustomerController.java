package com.ofss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// controller layer
@RestController
public class CustomerController {

	// Let's inject the CustomerService object here, there is a special annotation
	// for this

	@Autowired
	CustomerService customerService;

	public CustomerController() {

	}

	// Flow
	// Client --> Controller --> Service --> data is created in this service class
	// Service --> Controller --> Client

	// API 1: Returning all the customer details in the form of JSON
	// Client will access: http://localhost:8081/customers with GET method
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// API 2: Returning the customer details based on the id
	@RequestMapping(value = "/customers/id/{custid}", method = RequestMethod.GET)
	public ResponseEntity<?> fetchCustomerById(@PathVariable("custid") int id) {
		System.out.println("GET: Received request for customer id: " + id);
		return customerService.fetchCustomerById(id);
	}

	// API 3: Adding a new customer object to existing allCustomers ArrayList
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer) {
		return customerService.addACustomer(newCustomer);
	}

	// API 4: Deleting the customer details based on the id
	@RequestMapping(value = "/customers/id/{custid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomerById(@PathVariable("custid") int id) {
		System.out.println("DELETE: Received request for customer id: " + id);
		return customerService.deleteCustomerById(id);
	}

	// API 5: PATCHING the customer details based on the id
	@RequestMapping(value = "/customers/id/{custid}", method = RequestMethod.PATCH)
	public ResponseEntity<?> patchCustomerById(@PathVariable("custid") int id, @RequestBody Customer updatedCustomer) {
		System.out.println("PATCH: Received request for customer id: " + id);
		return customerService.patchCustomerById(id, updatedCustomer);
	}

	// API 6: Updating all the customer details based on the id
	@RequestMapping(value = "/customers/id/{custid}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomerById(@PathVariable("custid") int id, @RequestBody Customer updatedCustomer) {
		System.out.println("PUT: Received request for customer id: " + id);
		return customerService.updateCustomerById(id, updatedCustomer);
	}
	
	// API 7: Sample api just to verify the swagger thing
		@RequestMapping(value = "/today", method = RequestMethod.GET)
		public String getToday() {
			return "Today is Thursday, 19th September 2024";
		}


}
