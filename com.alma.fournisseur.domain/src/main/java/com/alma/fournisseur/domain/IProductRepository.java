package com.alma.fournisseur.domain;

public interface IProductRepository {
	
	/**
	 * Show a product
	 * @param entity
	 * @return
	 */
	public Product displayOneProduct(Product entity);
	
	/**
	 * Show a product
	 * @param entity
	 * @return
	 */
	public Product displayAllProducts();
	
	/**
	 * Modify a product
	 * @param entity
	 */
	public void updateProduct(Product entity);
	
	/**
	 * Delete a product
	 * @param entity
	 */
	public void deleteProduct(Product entity);
	
}
