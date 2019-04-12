package com.example.springdataenvers.dao;

import java.util.List;

import com.example.springdataenvers.model.ProductRevision;

public interface IProductRevisionQuery {

	List<ProductRevision> getRevisionsById(Long id);

}
