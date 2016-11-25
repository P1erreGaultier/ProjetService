package com.alma.fournisseur.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liciax
 *
 */ 
public class Storage implements IProductRepository {
	
	private Map<Product, Integer> products;

	public Storage() {
		this.products = new HashMap<Product, Integer>();
	}

	@Override
	public void create(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product read(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub
		
	}
}
