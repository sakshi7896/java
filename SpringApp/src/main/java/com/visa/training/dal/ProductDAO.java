package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.Product;

public interface ProductDAO {

	void delete(int id);

	void changePrice(int id, float newPrice);

	List<Product> findAll();

	List<Product> findByPriceGreaterThan(float price);

	int removeOutOfStocks();

	Product findOne(int id);

	Product addNew(Product p);

}