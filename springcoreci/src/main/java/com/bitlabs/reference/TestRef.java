package com.bitlabs.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context=new ClassPathXmlApplicationContext("com/bitlabs/reference/refconfig.xml");
Employee emp=(Employee)context.getBean("employee");
emp.display();

	}

}
