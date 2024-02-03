package com.customer.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.entity.CustomerEntity;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {		
		return customerRepository.save(customerEntity);
	}

	@Override
	public List<CustomerEntity> getAllCustomer() {		
		return customerRepository.findAll();
	}

	@Override
	public CustomerEntity getCustomerById(Long Id) {
		return customerRepository.findById(Id).get();
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity CustomerEntity) {
		return customerRepository.save(CustomerEntity);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}

}
