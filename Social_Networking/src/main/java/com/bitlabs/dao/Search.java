package com.bitlabs.dao;

public class Search {
	int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	String fromAge;
	String toAge;
	String city;
	String gender;
	String marital;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getFromAge() {
		return fromAge;
	}
	public void setFromAge(String fromAge) {
		this.fromAge = fromAge;
	}
	public String getToAge() {
		return toAge;
	}
	public void setToAge(String toAge) {
		this.toAge = toAge;
	}
}
