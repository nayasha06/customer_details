package com.customer.service;

import java.util.List;

import com.customer.entity.CustomerEntity;

public interface CustomerService {
	
	List<CustomerEntity> getAllCustomer();
	
	CustomerEntity saveCustomer(CustomerEntity CustomerEntityCustomerEntity);
	
	CustomerEntity getCustomerById(Long Id);
	
	CustomerEntity updateCustomer(CustomerEntity CustomerEntity);
	
	void deleteCustomerById(Long id);

}
