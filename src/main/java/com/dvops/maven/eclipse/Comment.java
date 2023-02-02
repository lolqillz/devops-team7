package com.dvops.maven.eclipse;

public class Comment {
	 protected String name;
	 protected Number id;
	 protected String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Comment(String name, Number id, String comment) {
		super();
		this.name = name;
		this.id = id;
		this.comment = comment;
	}
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}