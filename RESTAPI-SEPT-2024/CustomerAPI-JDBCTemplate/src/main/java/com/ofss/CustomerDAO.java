package com.ofss;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAO extends JdbcDaoSupport {
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void init() {
		setDataSource(dataSource);
		
    }

	// Method 1 for inserting the customer details into CUSTOMER table
	public ResponseEntity<?> insertCustomer(Customer customer) {
		JdbcTemplate jdbcTemplate=getJdbcTemplate();
		String sql="INSERT INTO CUSTOMERS VALUES(?,?,?,?,?)";
		// call update method from JdbcTemplate
		int rowsAffected=jdbcTemplate.update(sql,customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(), customer.getEmailId());
		if (rowsAffected > 0) {
			System.out.println("Customer details inserted successfully");
			return ResponseEntity.ok("Customer details inserted successfully");
		} else {
			System.out.println("Customer details not inserted, just check for log messages");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customer details not inserted, just check for log messages");
		}
	}
}
