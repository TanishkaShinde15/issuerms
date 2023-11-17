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
	private String noOfCopiesNote;

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

	public String getNoOfCopiesNote() {
		return noOfCopiesNote;
	}

	public void setNoOfCopiesNote(String noOfCopiesNote) {
		this.noOfCopiesNote = noOfCopiesNote;
	}
	
	

}
