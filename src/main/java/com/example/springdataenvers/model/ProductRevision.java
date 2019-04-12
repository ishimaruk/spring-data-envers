package com.example.springdataenvers.model;

import java.util.Date;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;

public class ProductRevision {
	private Product product;
	private DefaultRevisionEntity revision;
	private RevisionType revisionType;

	public ProductRevision() {
		super();
	}

	public ProductRevision(Product product, DefaultRevisionEntity revision, RevisionType revisionType) {
		super();
		this.product = product;
		this.revision = revision;
		this.revisionType = revisionType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public RevisionType getRevisionType() {
		return revisionType;
	}

	public void setRevisionType(RevisionType revisionType) {
		this.revisionType = revisionType;
	}

	public Number getRevisionNumber() {
		return revision.getId();
	}

	public Date getRevisionDate() {
		return revision.getRevisionDate();
	}

}
