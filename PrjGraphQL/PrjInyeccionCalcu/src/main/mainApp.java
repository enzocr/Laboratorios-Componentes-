package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import testbean.BeanWithDependency;

public class mainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		BeanFactory factory = context;
		BeanWithDependency test = (BeanWithDependency) factory.getBean("BeanWithDependency");
		test.run();
	}

}
