package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alma.fournisseur.domain.IProductRepository;
import com.alma.fournisseur.domain.Product;

public class ProductRepository implements IProductRepository{

	public Product displayOneProduct(int id) {
		Map<String,String> prod = DBHandler.getInstance().retrieve(id);
		return new Product(prod.get("name"),prod.get("description"),Float.parseFloat(prod.get("price")), id);
	}

	public List<Product> displayAllProducts() {
		ArrayList<Product> res = new ArrayList<Product>();
		for(Map<String, String> m : DBHandler.getInstance().retrieveAll()){
			res.add(new Product(m.get("name"),m.get("description"),Float.parseFloat(m.get("price")), Integer.parseInt(m.get("id"))));
		}
		return res;
	}


	@Override
	public void deleteProduct(int id) {
		DBHandler.getInstance().delete(id);	
	}

}
