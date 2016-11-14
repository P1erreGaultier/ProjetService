package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.alma.fournisseur.domain.IEntity;

public interface Factory {
	
	public IEntity getProduct(int id);

	public List<IEntity> getAllProduct();

	public void closeDB();

}
