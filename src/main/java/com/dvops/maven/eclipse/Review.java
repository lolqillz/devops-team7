package com.dvops.maven.eclipse;

public class Review {
	 protected String name;
	 protected Number id;
	 protected Number book_id;
	 protected String review;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Review(String name, Number id, Number book_id, String review) {
		super();
		this.name = name;
		this.id = id;
		this.book_id = book_id;
		this.review = review;
	}
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public Number getBook_id() {
		return book_id;
	}
	public void setBook_id(Number book_id) {
		this.book_id = book_id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}