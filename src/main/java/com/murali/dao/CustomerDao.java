package com.murali.dao;

import java.util.List;

import com.murali.model.Customer;

public interface CustomerDao {
	void saveCustomer(Customer customer);
	List<Customer> getCustomers();

}
