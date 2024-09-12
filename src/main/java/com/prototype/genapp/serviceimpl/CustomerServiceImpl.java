package com.prototype.genapp.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prototype.genapp.entity.Customer;
import com.prototype.genapp.repository.CustomerRepository;
import com.prototype.genapp.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	 private final CustomerRepository customerRepository;

	    @Autowired
	    public CustomerServiceImpl(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }

	    @Override
	    public Customer getCustomerById(int customerId) {
	        return customerRepository.findById(customerId).orElse(null);
	    }

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public Customer createCustomer(Customer customer) {
	        //  Ensure that the email address is unique before saving
	        customer.setPassword("PASSW0RD");
	        return customerRepository.save(customer);
	    }

	    
	    @Override
	    public Customer saveCustomer(Customer customer) {
	        if (isEmailAlreadyRegistered(customer.getEmailaddress())) {
	            throw new IllegalArgumentException("Email address is already registered");
	        }	        
	        //  Convert the email address to lowercase before saving
	        customer.setEmailaddress(customer.getEmailaddress().toLowerCase());
	        return customerRepository.save(customer);
	    }

	    
	    private boolean isEmailAlreadyRegistered(String emailAddress) {
	        Customer existingCustomer = customerRepository.findByEmailaddress(emailAddress);
	        return existingCustomer != null;
	    }

	    @Override
	    public Customer updateCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @Override
	    public void deleteCustomer(int customerId) {
	        customerRepository.deleteById(customerId);
	    }

	    @Override
	    public Customer getCustomerByCustomernumber(int customernumber) {
	        return customerRepository.findByCustomernumber(customernumber);
	    }
	    
	    @Override
	    public boolean existsByCustomernumber(int customernumber) {
	        return customerRepository.existsByCustomernumber(customernumber);
	    }
	    
	    
	    
	    
	    
	    @Override
	    public Customer updateCustomerpassword(Customer customer) {
	        // Retrieve existing customer from the database
	    	Customer existingCustomer = customerRepository.findById(customer.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

	        // Validate new password
	        if (!isValidPassword(customer.getPassword())) {
	            throw new IllegalArgumentException("Invalid password");
	        }

	        // Ensure the new password is not the same as the old password
	        if (existingCustomer.getPassword().equals(customer.getPassword())) {
	            throw new IllegalArgumentException("New password must be different from the old password");
	        }

	        // Hash the new password before saving
	        String hashedPassword = hashPassword(customer.getPassword());
	        existingCustomer.setPassword(hashedPassword);


	        // Save the updated customer record
	        return customerRepository.save(existingCustomer);
	    }

	    private boolean isValidPassword(String password) {
	        // Implement password validation logic
	        return password.length() >= 8 &&             // Minimum length of 8 characters
	               password.matches(".*[A-Z].*") &&      // Contains at least one uppercase letter
	               password.matches(".*[a-z].*") &&      // Contains at least one lowercase letter
	               password.matches(".*\\d.*") &&        // Contains at least one digit
	               password.matches(".*[!@#$%^&*].*");   // Contains at least one special character
	    }


	    private String hashPassword(String password) {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        return encoder.encode(password);
	    }

}


