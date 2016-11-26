package com.alma.fournisseur.infrastructure;

import com.alma.fournisseur.domain.IFactory;
import com.alma.fournisseur.domain.Entity;
import com.alma.fournisseur.domain.Product;

public class ProductFactory implements IFactory{
	
	public ProductFactory(){
		DBHandler.getInstance().openDB();
	}
	

	public Entity create(String name, String description, Float price, int id,int nb_stock) {
		DBHandler.getInstance().create(name,description,price,id,nb_stock);
		return new Product(name,description,price,nb_stock,id);
	}
	
	
	public void closeDB(){
		DBHandler.getInstance().closeDB();
	}

}
