package com.alma.fournisseur.infrastructure;

import com.alma.fournisseur.domain.IFactory;
import com.alma.fournisseur.domain.Entity;
import com.alma.fournisseur.domain.Product;

public class ProductFactory implements IFactory{
	
	public ProductFactory(){
		DBHandler.getInstance().openDB();
	}
	
	@Override
	public Entity create(String name, String description, Float price, int id,int nbStock) {
		DBHandler.getInstance().create(name, description, price, id, nbStock);
		return new Product(name, description, price, id, nbStock);
	}
	
	
	public void closeDB(){
		DBHandler.getInstance().closeDB();
	}

}
