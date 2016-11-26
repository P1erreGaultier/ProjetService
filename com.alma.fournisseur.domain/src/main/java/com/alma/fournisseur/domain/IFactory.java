package com.alma.fournisseur.domain;


public interface IFactory {
	
	public Entity create(String name, String description, Float price, int id);
	
}
