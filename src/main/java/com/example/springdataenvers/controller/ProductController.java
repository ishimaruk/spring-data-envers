package com.example.springdataenvers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdataenvers.dao.IProductRepository;
import com.example.springdataenvers.dao.IProductRevisionQuery;
import com.example.springdataenvers.model.Product;
import com.example.springdataenvers.model.ProductRevision;

@RestController
public class ProductController {

	@Autowired
	private IProductRepository repository;

	@Autowired
	private  IProductRevisionQuery revisionQuery;

	@RequestMapping("/list")
	public List<Product> list() {
		return (List<Product>) repository.findAll();
	}

	@GetMapping("/getProductById/{id}")
	public Product getById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	@PostMapping("/save")
	public String save(@RequestBody Product product) {
		repository.save(product);
		return "Saved.";

	}

	@PostMapping("/update")
	public String update(@RequestBody Product product) {
		Product item = getById(product.getId());
		item.setCode(product.getCode());
		item.setName(product.getName());
		item.setPrice(product.getPrice());
		repository.save(item);
		return "Updated.";
	}

	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deleted.";
	}

	@GetMapping("/getProductRevisionsById/{id}")
	public List<ProductRevision> getLogById(@PathVariable Long id) {
		return revisionQuery.getRevisionsById(id);
	}

}
