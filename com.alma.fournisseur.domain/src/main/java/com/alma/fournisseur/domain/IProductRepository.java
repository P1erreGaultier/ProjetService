package com.alma.fournisseur.domain;

import java.util.List;

public interface IProductRepository {
	
	/**
	 * Show a product
	 * @param entity
	 * @return
	 */
	public Product displayOneProduct(int id);
	
	/**
	 * Show a product
	 * @param entity
	 * @return
	 */
	public List<Product> displayAllProducts();
	
	/**
	 * Delete a product
	 * @param entity
	 */
	public void deleteProduct(int id);
	
}
