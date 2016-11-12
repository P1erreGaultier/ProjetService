package com.alma.fournisseur.infrastructure;

import com.alma.fournisseur.domain.IEntity;

public class Infrastruture {
	
	public IEntity getProduct(int id){
		
		Factory f = new ProductFactory();
		return f.getProduct(id);
	}

}
