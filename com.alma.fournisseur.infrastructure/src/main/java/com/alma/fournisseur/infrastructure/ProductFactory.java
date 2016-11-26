package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alma.fournisseur.domain.IFactory;
import com.alma.fournisseur.domain.Entity;
import com.alma.fournisseur.domain.Product;

public class ProductFactory implements IFactory{
	
	public ProductFactory(){
		DBHandler.getInstance().openDB();
	}
	

	public Entity create(String name, String description, Float price, int id) {
		DBHandler.getInstance().create(name,description,price,id);
		return new Product(name,description,price,id);
	}
	
	
	public void closeDB(){
		DBHandler.getInstance().closeDB();
	}


}
