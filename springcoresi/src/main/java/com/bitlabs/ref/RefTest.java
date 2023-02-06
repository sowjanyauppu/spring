package com.bitlabs.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("com/bitlabs/ref/refconfig.xml");
		History temp=(History)context.getBean("historyref");		
		System.out.println(temp.getOb().getPid()+" "+temp.getOb().getPname());
		System.out.println(temp.getHname());
		

	}

}
