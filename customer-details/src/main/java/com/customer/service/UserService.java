package com.customer.service;

import com.customer.entity.User;

public interface UserService {
	
	User loadUserByUsername(String username);

}
