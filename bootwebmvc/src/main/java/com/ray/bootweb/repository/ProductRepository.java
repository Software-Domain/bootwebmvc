package com.ray.bootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ray.bootweb.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);
}
