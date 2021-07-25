package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;
import com.example.demo.vo.Customer;

@RestController
@RequestMapping("/customer/v1")
@Validated
public class CustomerController {
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService CustomerService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<Customer> getCustomerDetail(HttpServletRequest httpRequest,
			@Size(min = 1, max = 80, message = "CustomerId size must be between 1 and 80") @RequestParam(value = "customerId", required = true) String customerId,
			HttpServletResponse httpResponse) {
		log.info("Entering into CustomerController ::: getCustomer - start");
		String transactionId = MDC.get("trackingId");
		Customer Customer = CustomerService.getCustomerDetails(customerId);
		log.info("Entering into CustomerController ::: getCustomer - end");
		return new ResponseEntity<>(Customer, HttpStatus.OK);

	}

}
