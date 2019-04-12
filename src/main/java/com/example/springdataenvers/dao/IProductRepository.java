package com.example.springdataenvers.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.springdataenvers.model.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {
}
