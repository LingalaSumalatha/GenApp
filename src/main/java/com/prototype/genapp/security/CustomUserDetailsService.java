package com.prototype.genapp.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prototype.genapp.entity.Customer;
//import com.prototype.genapp.entity.Role;
import com.prototype.genapp.repository.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private CustomerRepository customerRepository;

	public CustomUserDetailsService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrCustomernumber) throws UsernameNotFoundException {
	    Customer customer = null;
	    
	    // Check if the input is a customernumber or emailaddress
	    if (usernameOrCustomernumber.contains("@")) {
	        // Find customer by emailaddress
	        customer = customerRepository.findByEmailaddress(usernameOrCustomernumber);
	    } else {
	        // Find customer by customernumber
	        customer = customerRepository.findByCustomernumber(Integer.parseInt(usernameOrCustomernumber));
	    }
	    return new User(
	            String.valueOf(customer.getCustomernumber()),
	            customer.getPassword(),
	            Collections.emptyList()); // No authorities
	   
	}


}