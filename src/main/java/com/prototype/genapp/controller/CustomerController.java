package com.prototype.genapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.genapp.entity.Customer;
import com.prototype.genapp.service.CustomerService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer Rest Api's")
//@Api(value = "Customer Management System", description = "Operations pertaining to customer in Customer Management System")
public class CustomerController {
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam int customernumber, @RequestParam String password) {
		// Check if the customer exists
		Customer customer = customerService.getCustomerByCustomernumber(customernumber);
		if (customer != null) {
			// Check if the password is correct
			if (customer.getPassword().equals(password)) {
				return ResponseEntity.ok("Login successfully");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
	}

	@ApiResponse(responseCode = "200", description = "Http Status 200 OK")
	@GetMapping("/{customernumber}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customernumber) {
		Customer customer = customerService.getCustomerById(customernumber);
		if (customer != null) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@ApiResponse(responseCode = "200", description = "Http Status 200 OK")
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	@ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
	}

	@PutMapping("/{customernumber}")
	@ApiResponse(responseCode = "200", description = "Http Status 200 OK")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int customernumber,
			@RequestBody Customer customerDetails) {
		Customer existingCustomer = customerService.getCustomerById(customernumber);
		if (existingCustomer != null) {
			customerDetails.setCustomernumber(customernumber);
			Customer updatedCustomer = customerService.updateCustomer(customerDetails);
			return ResponseEntity.ok(updatedCustomer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{customernumber}")
	@ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customernumber) {
		Customer existingCustomer = customerService.getCustomerById(customernumber);
		if (existingCustomer != null) {
			customerService.deleteCustomer(customernumber);
			return ResponseEntity.noContent().build(); // Return 204 No Content
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/register")
	@ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		// Check if the customer already exists
		if (customerService.existsByCustomernumber(customer.getCustomernumber())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Custom response for existing customer
		}

		// Save the new customer
		Customer savedCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
	}

	@PutMapping("/{customernumber}/change-password")
	@ApiResponse(responseCode = "200", description = "Http Status 200 OK")
	public ResponseEntity<String> changePassword(@PathVariable int customernumber, @RequestParam String newPassword) {
		Customer existingCustomer = customerService.getCustomerById(customernumber);
		if (existingCustomer != null) {
			// Update the password with the new password
			existingCustomer.setPassword(newPassword);
			customerService.updateCustomer(existingCustomer);
			return ResponseEntity.ok("Password changed successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
