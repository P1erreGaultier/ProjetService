package com.alma.fournisseur.domain;

import java.util.List;


public interface IRepository{
	
	/**
	 * Show a Entity
	 * @param entity
	 * @return
	 */
	public Entity displayOneEntity(int id);
	
	/**
	 * Show a Entity
	 * @param entity
	 * @return
	 */
	public List<Entity> displayAllEntitys();
	
	
	/**
	 * Delete a Entity
	 * @param entity
	 */
	public void deleteEntity(int id);

	Entity createEntity(String name, String description, Float price, int id, int nbStock);

	void updateStockPurchased(int id);
	
}
