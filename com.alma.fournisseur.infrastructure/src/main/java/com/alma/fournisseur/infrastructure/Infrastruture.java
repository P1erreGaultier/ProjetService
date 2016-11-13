package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;

import com.alma.fournisseur.domain.IEntity;

public class Infrastruture {
	
	private Factory f;
	
	public Infrastruture(){
		f = new ProductFactory();
	}
	
	public IEntity getProduct(int id){		
		return f.getProduct(id);
	}

	public ArrayList<IEntity> getAllProduct(){	
		return f.getAllProduct();
	}
}
