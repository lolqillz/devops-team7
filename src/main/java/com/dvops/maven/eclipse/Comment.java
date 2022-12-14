package com.dvops.maven.eclipse;

public class Comment {

	protected String name;
	protected String comment;
	public Comment(String name, String comment) {
		super();
		this.name = name;
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
