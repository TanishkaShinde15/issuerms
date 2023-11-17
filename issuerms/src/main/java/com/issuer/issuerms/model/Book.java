package com.issuer.issuerms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Book  {
	
	
	private String isbn;
	
	
	private String title;
	
	private String publishedDate;
	
	
	private String totalCopies;
	

	private String issuedCopies;
	
	
	private String author;
	
	public Book() {
		
	}
	
	@JsonCreator
	public Book(String isbn, String title, String publishedDate, String totalCopies, String issuedCopies,
			String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publishedDate = publishedDate;
		this.totalCopies = totalCopies;
		this.issuedCopies = issuedCopies;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(String totalCopies) {
		this.totalCopies = totalCopies;
	}

	public String getIssuedCopies() {
		return issuedCopies;
	}

	public void setIssuedCopies(String issuedCopies) {
		this.issuedCopies = issuedCopies;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}
