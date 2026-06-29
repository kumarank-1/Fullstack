package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("beans.xml");
		User uObj = (User) c.getBean("userBean");
		System.out.println(uObj.getUsername() + " " + uObj.getPassword());
	}
}
