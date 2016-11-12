package com.alma.fournisseur.infrastructure;

import java.util.Map;

import com.alma.fournisseur.domain.IEntity;
import com.alma.fournisseur.domain.Product;

public class ProductFactory implements Factory{
	
	public IEntity getProduct(int id){
		DBHandler dbh = new DBHandler();
		Map<String,String> prod = dbh.getProductInDatabase(id);
		return new Product(prod.get("name"),prod.get("description"),Float.parseFloat(prod.get("price")));
			
	}

}
