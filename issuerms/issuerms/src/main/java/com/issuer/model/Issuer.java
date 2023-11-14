package com.issuer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Issuer {
	
	private String isbn;
	private String custId;
	private String noOfCopies;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(String noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	public Issuer() {
		
	}
	public Issuer(String isbn, String custId, String noOfCopies) {
		super();
		this.isbn = isbn;
		this.custId = custId;
		this.noOfCopies = noOfCopies;
	}
	
	

}
