package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;

import com.alma.fournisseur.domain.IEntity;

public interface Factory {
	
	public IEntity getProduct(int id);

	public ArrayList<IEntity> getAllProduct();

}
