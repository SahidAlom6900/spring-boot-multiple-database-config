package com.te.two.db.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.two.db.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}