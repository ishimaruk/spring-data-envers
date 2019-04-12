package com.example.springdataenvers.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;

import com.example.springdataenvers.model.Product;
import com.example.springdataenvers.model.ProductRevision;

@Component
public class ProductRevisionQuery implements IProductRevisionQuery {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductRevision> getRevisionsById(Long id) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);

		AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Product.class, false, true)
				.add(AuditEntity.id().eq(id));

		List<?> results = auditQuery.getResultList();

		return results.stream().map(x -> (Object[]) x)
				.map(x -> new ProductRevision((Product) x[0], (DefaultRevisionEntity) x[1], (RevisionType) x[2]))
				.collect(Collectors.toList());
	}

}
