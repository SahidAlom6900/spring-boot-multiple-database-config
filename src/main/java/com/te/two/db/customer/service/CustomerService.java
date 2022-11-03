package com.te.two.db.customer.service;

import com.te.two.db.customer.dto.CustomerDto;

public interface CustomerService {
	
	String addCustomer(CustomerDto customerDto);
	
	CustomerDto getCustomer(Long customerId);

}
