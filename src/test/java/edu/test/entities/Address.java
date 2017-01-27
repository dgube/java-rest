package edu.test.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	
	@JsonProperty("street")
	private String street;
	
	@JsonProperty("suite")
	private String suite;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("zipcode")
	private String zipCode;
	
	@JsonProperty("geo")
	private Geo geo;
	
	
	public Address() {
//		serialization needs default constructor
	}

	public Address(String street, String suite, String city, String zipCode, Geo geo) {
		super();
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipCode = zipCode;
		this.geo = geo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipCode=" + zipCode + ", geo="
				+ geo + "]";
	}

}
