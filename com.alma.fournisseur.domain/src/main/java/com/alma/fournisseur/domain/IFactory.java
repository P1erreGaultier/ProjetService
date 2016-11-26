package com.alma.fournisseur.domain;

import java.util.ArrayList;
import java.util.List;

public interface IFactory {
	
	public IEntity create(String name, String description, Float price, int id);
	

}
