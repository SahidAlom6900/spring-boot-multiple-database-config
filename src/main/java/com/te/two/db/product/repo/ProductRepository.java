package com.te.two.db.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.two.db.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}