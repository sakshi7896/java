package com.visa.training.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visa.training.domain.Product;

public class ProductServiceTest {

	@Test
	public void addNewMustSucceeedIfProductValueGT10000() {
		ProductService service= new ProductService();
		Product p= new Product("testproduct", 10000, 1);
		Product created =service.addNew(p);
		assertNotNull(created);
		assertTrue(created.getId()>0);
		
	}

}
