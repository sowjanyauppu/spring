package com.bitlabs.springcoreci;

public class Employee {
	private int eid;
	private String ename;
	public Employee(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	void display()
	{
		System.out.println(eid+" "+ename);
	}

}
