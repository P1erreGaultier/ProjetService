package com.alma.fournisseur.infrastructure;

import com.alma.fournisseur.domain.IEntity;

public interface Factory {
	
	public IEntity getProduct(int id);

}
