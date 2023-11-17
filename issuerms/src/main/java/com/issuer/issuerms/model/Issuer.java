package com.issuer.issuerms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Issuer {
	
	@Id
	private String isbn;
	
	@Column
	private String custId;
	
	@Column
	private Integer noOfCopiesNote;

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

	public Integer getNoOfCopiesNote() {
		return noOfCopiesNote;
	}

	public void setNoOfCopiesNote(Integer noOfCopiesNote) {
		this.noOfCopiesNote = noOfCopiesNote;
	}
	
	

}
