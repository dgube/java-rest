package edu.test.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
	
	@JsonProperty("userId")
	private int userId;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("body")
	private String body;
	
	public Post() {
//		serialization needs default constructor	
	}

	public Post(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
	public boolean hasValidId() {
		// TODO Auto-generated method stub
		return getId() > 0;
	}

	public boolean hasValidTitle() {
		// TODO Auto-generated method stub
		return !getTitle().isEmpty();
	}

	public boolean hasValidBody() {
		// TODO Auto-generated method stub
		return !getBody().isEmpty();
	}

}
