package com.alma.fournisseur.domain;

@FunctionalInterface
public interface IFactory {
	
	public Entity create(String name, String description, Float price, int id, int nbStock);
	
}
