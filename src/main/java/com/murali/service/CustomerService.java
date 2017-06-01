package com.murali.service;

import java.util.List;

import com.murali.model.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);
	List<Customer> getCustomers();
	
}
