package com.customer.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.CustomerEntity;
import com.customer.entity.User;
import com.customer.repository.UserRepository;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerService;
	private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

	public CustomerController(CustomerService customerService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.customerService = customerService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

   @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/customerEntity";
        } else {
            return "Invalid username or password!";
        }
    }
	
	@GetMapping("/customerEntity")
	public String listCustomer(Model model) {
		model.addAttribute("customerEntity", customerService.getAllCustomer());
		return "customerEntity";
	}
	
	@GetMapping("/customerEntity/new")
	public String createCustomerForm(Model model) {
		CustomerEntity customerEntity = new CustomerEntity();
		model.addAttribute("customerEntity", customerEntity);
		return "create_customer";
	}
	
	@PostMapping("/customerEntity")
	public String saveCustomer(@ModelAttribute("customerEntity") CustomerEntity customerEntity) {
		customerService.saveCustomer(customerEntity);
		return "redirect:/customerEntity";
	}
	
	@GetMapping("/customerEntity/edit/{id}")
	public String editCustomerForm(@PathVariable Long id, Model model) {
		model.addAttribute("customerEntity", customerService.getCustomerById(id));
		return "edit_customer";
	}
	
	@PutMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("customerEntity") CustomerEntity customerEntity, Model model) {
		CustomerEntity existingCustomerEntity = customerService.getCustomerById(id);
		existingCustomerEntity.setId(id);
		existingCustomerEntity.setFirstName(customerEntity.getFirstName());
		existingCustomerEntity.setLastName(customerEntity.getLastName());
		existingCustomerEntity.setStreet(customerEntity.getStreet());
		existingCustomerEntity.setAddress(customerEntity.getAddress());
		existingCustomerEntity.setCity(customerEntity.getCity());
		existingCustomerEntity.setState(customerEntity.getState());
		existingCustomerEntity.setEmail(customerEntity.getEmail());
		existingCustomerEntity.setPhone(customerEntity.getPhone());
		
		customerService.updateCustomer(existingCustomerEntity);
		return "redirect:/customerEntity";
	}
	
	@GetMapping("/students/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customerEntity";
	}

}
