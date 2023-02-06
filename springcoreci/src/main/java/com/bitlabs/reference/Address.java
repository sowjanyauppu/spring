package com.bitlabs.reference;

public class Address {
String street;
String city;
String state;
String country;
public Address(String street, String city, String state, String country) {
	super();
	this.street = street;
	this.city = city;
	this.state = state;
	this.country = country;
}
@Override
public String toString() {
	return "Address [street=" + street + ", city=" + city + ", state=" + state + ", country=" + country + "]";
}

}
