package com.visa.training;

import java.util.List;

import com.visa.training.dal.MySqlProductDAO;
import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ProductDAO pd= new MySqlProductDAO();
		Product p = new Product("Samsung", 0.8f, 10);
//		List<Product> l = pd.findByPriceGreaterThan(30);
		//List<Product> l = pd.findByPriceGreaterThan(30);
		int x=pd.removeOutOfStocks();
		System.out.println(x);
		List<Product> l = pd.findAll();
		l.forEach(System.out::println);
		//pd.delete(1);
	}

}
