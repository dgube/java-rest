package edu.test.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geo {
	
	@JsonProperty("lat")
	private String latitude;
	
	@JsonProperty("lng")
	private String longitude;
	
	public Geo() {
//		serialization needs default constructor
	}
	
	public Geo(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Geo [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
