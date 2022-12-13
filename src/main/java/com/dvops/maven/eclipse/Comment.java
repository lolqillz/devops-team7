package com.dvops.maven.eclipse;

public class Comment {
	protected String name;
	public Comment(String name, String comment) {
		super();
		this.name = name;
		this.comments = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comments;
	}
	public void setComment(String comment) {
		this.comments = comment;
	}
	
	
	protected String comments;
}
