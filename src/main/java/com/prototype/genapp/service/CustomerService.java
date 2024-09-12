package com.prototype.genapp.service;

import java.util.List;

import com.prototype.genapp.entity.Customer;

public interface CustomerService 
{
    Customer getCustomerById(int customerId);
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
	Customer getCustomerByCustomernumber(int customernumber);
	boolean existsByCustomernumber(int customernumber);
	Customer updateCustomerpassword(Customer customer);
}