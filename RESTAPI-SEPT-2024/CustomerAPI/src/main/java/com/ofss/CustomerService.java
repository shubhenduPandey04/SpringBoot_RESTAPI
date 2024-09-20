package com.ofss;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// View layer
// in REST API, the service layer is responsible for creating the dataset
@Service
public class CustomerService {

	List<Customer> allCustomers = new ArrayList<Customer>();

	public CustomerService() {
		// Let's create 5 instances / objects of Customer class with different data
		// add it to the ArrayList
		Customer c1 = new Customer(101, "Raj", "Kumar", 9876543210L, "raj@oracle.com");
		Customer c2 = new Customer(102, "Ravi", "Patel", 9876543211L, "ravi@yaho.com");
		Customer c3 = new Customer(103, "Rahul", "Sharma", 9876543212L, "rahul.sharma@gmail.com");
		Customer c4 = new Customer(104, "Rajesh", "Kumar", 9876543213L, "rajesh@gmail.com");
		Customer c5 = new Customer(105, "Rakesh", "Patel", 9876543214L, "rakesh@oracle.com");
		Customer c6 = new Customer(106, "Krishna", "Yadav", 9876543214L, "krishna@oracle.com");
		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);
		allCustomers.add(c4);
		allCustomers.add(c5);
		allCustomers.add(c6);
		System.out.println("From CustomerService, the ArrayList of customers is created....!!!");
	}

	// Response is generated and returned from here
	public List<Customer> getAllCustomers() {
		return allCustomers;
	}

	// implement the method to fetch the customer based on the id
	public ResponseEntity<?> fetchCustomerById(int id) {
		for (Customer c : allCustomers) {
			if (c.getId() == id) {
				return ResponseEntity.ok(c);
			}
		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with id: " + id);
		throw new ResourceNotFoundException("Customer not found with id:"+ id);
	}

	// A method to add the customer
	public ResponseEntity<?> addACustomer(Customer newCustomer) {
	
		if (newCustomer.getPhoneNumber() == 0) {
		    throw new InvalidCustomerDetailsException("Phone number cannot be 0");
		}

		
		newCustomer.setId(UUID.randomUUID().hashCode());
		allCustomers.add(newCustomer);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Customer added successfully with id: " + newCustomer.getId());
	}

	// Delete the customer based on the id
		public ResponseEntity<?> deleteCustomerById(int id) {
			
			if (id == 101) {
				throw new CustomerDeletionNotAllowedException("Customer deletion not allowed for id: " + id);
			}
			
			for (Customer c : allCustomers) {
				if (c.getId() == id) {
					allCustomers.remove(c);
					return ResponseEntity.ok("Customer deleted successfully with id: " + id);
//					return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer deleted successfully with id: " + id);
				}
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with id: " + id);
		}


	// Patch the customer based on the id
	public ResponseEntity<?> patchCustomerById(int id, Customer updatedCustomer) {
		boolean isUpdated = false;
		// Step 1: Find the customer based on the id
		for (Customer c : allCustomers) {
			// Step 2: Update the customer details
			if (c.getId() == id) {
				isUpdated = true;
				// update the phone number
				if (updatedCustomer.getPhoneNumber() != 0) {
					c.setPhoneNumber(updatedCustomer.getPhoneNumber());

				}

				// update the email id
				if (updatedCustomer.getEmailId() != null) {
					c.setEmailId(updatedCustomer.getEmailId());

				}

				// update the first name
				if (updatedCustomer.getFirstName() != null) {
					c.setFirstName(updatedCustomer.getFirstName());

				}

				// update the last name
				if (updatedCustomer.getLastName() != null) {
					c.setLastName(updatedCustomer.getLastName());

				}
			}
		} // end of for loop

		if (isUpdated) {
			return ResponseEntity.ok("Customer updated successfully for id: " + id);

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with id: " + id);

	}

	// Update the customer based on the id
	public ResponseEntity<?> updateCustomerById(int id, Customer updatedCustomer) {
		for (Customer c : allCustomers) {
			if (c.getId() == id) {
				c.setFirstName(updatedCustomer.getFirstName());
				c.setLastName(updatedCustomer.getLastName());
				c.setPhoneNumber(updatedCustomer.getPhoneNumber());
				c.setEmailId(updatedCustomer.getEmailId());
				return ResponseEntity.ok("Customer updated successfully for id: " + id);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with id: " + id);
	}

}
