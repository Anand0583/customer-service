package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.vo.Customer;

@Component
public class CustomerService {
	
	
	public Customer getCustomerDetails(String customerId) {
		Customer customerVO = new Customer();
		customerVO.setCustomerId(customerId);
		customerVO.setCustomerName("Test Customer");
		return customerVO;
	}

}
