package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.customer.entity.CustomerEntity;
import com.customer.entity.User;
import com.customer.repository.CustomerRepository;
import com.customer.repository.UserRepository;

@SpringBootApplication
public class CustomerDetailsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CustomerDetailsApplication.class, args);
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		CustomerEntity customerEntity1 = new CustomerEntity("Sakshi", "Sharma", "Hno 1", "Delhi", "Delhi", "India", "sam@gmail.com", 10258);
//		customerRepository.save(customerEntity1);
//		
//		CustomerEntity customerEntity2 = new CustomerEntity("Nikhil", "Sharma", "Hno 1", "Delhi", "Delhi", "India", "sam@gmail.com", 10258);
//		customerRepository.save(customerEntity2);
//		
//		CustomerEntity customerEntity3 = new CustomerEntity("Ronit", "Sharma", "Hno 1", "Delhi", "Delhi", "India", "sam@gmail.com", 10258);
//		customerRepository.save(customerEntity3);
//		
//		User user1 = new User("abc", "abc");
//		userRepository.save(user1);
	}

}
