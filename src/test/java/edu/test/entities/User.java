package edu.test.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("address")
	private Address address;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("website")
	private String webSite;
	
	@JsonProperty("company")
	private Company company;
	
	public User() {
//		serialization needs default constructor
	}

	public User(int id, String name, String userName, String email, Address address, String phone, String webSite,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.webSite = webSite;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void seteMail(String eMail) {
		this.email = eMail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", eMail=" + email + ", address="
				+ address + ", phone=" + phone + ", webSite=" + webSite + ", company=" + company + "]";
	}
	
}
