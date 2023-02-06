package com.bitlabs.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
private String ename;
private List<String> phoneno;
private Set<String> address;
private Map<String,String> courses;
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public List<String> getPhoneno() {
	return phoneno;
}
public void setPhoneno(List<String> phoneno) {
	this.phoneno = phoneno;
}
public Set<String> getAddress() {
	return address;
}
public void setAddress(Set<String> address) {
	this.address = address;
}
public Map<String, String> getCourses() {
	return courses;
}
public void setCourses(Map<String, String> courses) {
	this.courses = courses;
}


}
