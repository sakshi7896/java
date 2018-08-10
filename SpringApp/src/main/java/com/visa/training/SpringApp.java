package com.visa.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

public class SpringApp {

	public static void main(String[] args) {
		ApplicationContext springContainer= 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("Spring container set up done.");
		ProductService service= (ProductService) springContainer.getBean("service");
		System.out.println("got service obj from container");
		Product test= new Product("spring", 99, 1000);
		Product created= service.addNew(test);
		System.out.println("Created product with id "+ created.getId());
		

	}

}
