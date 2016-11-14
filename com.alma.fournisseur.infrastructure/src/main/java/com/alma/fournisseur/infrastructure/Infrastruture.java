package com.alma.fournisseur.infrastructure;

import java.util.List;

import com.alma.fournisseur.domain.IEntity;

public class Infrastruture {
	
	private Factory f;
	
	public Infrastruture(){
		f = new ProductFactory();
	}
	
	public IEntity getProduct(int id){		
		return f.getProduct(id);
	}

	public List<IEntity> getAllProduct(){	
		return f.getAllProduct();
	}
	
	public void closeDB(){
		f.closeDB();
	}
}
