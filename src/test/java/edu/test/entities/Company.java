package edu.test.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("catchPhrase")	
	private String catchPhrase;
	
	@JsonProperty("bs")
	private String bs;
	
	public Company() {
//		serialization needs default constructor
	}
	
	public Company(String name, String catchPhrase, String bs) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}
	
}
