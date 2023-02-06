package com.bitlabs.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("com/bitlabs/collections/collectionsconfig.xml");
        Employee employee1=(Employee)context.getBean("employee1");
   		System.out.println(employee1.getEname()+" "+employee1.getPhoneno()+" "+employee1.getCourses()+" "+employee1.getAddress());

	}

}
