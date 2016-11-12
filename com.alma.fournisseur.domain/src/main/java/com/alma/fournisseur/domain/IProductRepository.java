package com.alma.fournisseur.domain;

public interface IProductRepository {
	/* CRUDE methods */
	
	/**
	 * Create a new product
	 * @param entity
	 */
	public void create(Product entity);
	
	/**
	 * Show a product
	 * @param entity
	 * @return
	 */
	public Product read(Product entity);
	
	/**
	 * Modify a product
	 * @param entity
	 */
	public void update(Product entity);
	
	/**
	 * Delete a product
	 * @param entity
	 */
	public void delete(Product entity);
	
//	public void execute();
}
