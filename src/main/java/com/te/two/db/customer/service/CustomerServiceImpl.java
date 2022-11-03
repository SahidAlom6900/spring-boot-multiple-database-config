package com.te.two.db.customer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.two.db.customer.dto.CustomerDto;
import com.te.two.db.customer.entity.Customer;
import com.te.two.db.customer.repo.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public String addCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customerRepository.save(customer);
		return "Customer Added Successfully";
	}

	@Override
	public CustomerDto getCustomer(Long customerId) {
		CustomerDto customerDto = new CustomerDto();
		Customer customer = customerRepository.findById(customerId).orElseThrow();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
	}

}
