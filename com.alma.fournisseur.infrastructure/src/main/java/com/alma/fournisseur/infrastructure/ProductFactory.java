package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alma.fournisseur.domain.IEntity;
import com.alma.fournisseur.domain.Product;

public class ProductFactory implements Factory{
	
	public ProductFactory(){
		DBHandler.getInstance().openDB();
	}
	
	public IEntity getProduct(int id){
		
		Map<String,String> prod = DBHandler.getInstance().getProductInDatabase(id);
		return new Product(prod.get("name"),prod.get("description"),Float.parseFloat(prod.get("price")));
			
	}

	@Override
	public ArrayList<IEntity> getAllProduct() {
		ArrayList<IEntity> res = new ArrayList<IEntity>();
		for(Map<String, String> m : DBHandler.getInstance().getProductInDatabase()){
			res.add(new Product(m.get("name"),m.get("description"),Float.parseFloat(m.get("price"))));
		}
		return res;
	}
	
	public void closeDB(){
		DBHandler.getInstance().closeDB();
	}
	
	

}
