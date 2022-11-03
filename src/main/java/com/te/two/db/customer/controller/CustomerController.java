package com.te.two.db.customer.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.two.db.customer.dto.CustomerDto;
import com.te.two.db.customer.response.CustomerResponse;
import com.te.two.db.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerDto customerDto) {
		return ResponseEntity.status(CREATED).body(CustomerResponse.builder().error(Boolean.FALSE)
				.message(customerService.addCustomer(customerDto)).build());
	}

	@GetMapping("{customerId}")
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long customerId) {
		return ResponseEntity.status(FOUND).body(CustomerResponse.builder().error(Boolean.FALSE)
				.message("Product Fatched Successfully").data(customerService.getCustomer(customerId)).build());
	}
}
