package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alma.fournisseur.domain.Entity;
import com.alma.fournisseur.domain.IRepository;
import com.alma.fournisseur.domain.Product;

public class ProductRepository implements IRepository{

	@Override
	public Product displayOneEntity(int id) {
		Map<String,String> prod = DBHandler.getInstance().retrieve(id);
		return new Product(prod.get("name"),prod.get("description"),Float.parseFloat(prod.get("price")), id,Integer.parseInt(prod.get("nb_prod")));
	}

	@Override
	public List<Entity> displayAllEntitys() {
		List<Entity> res = new ArrayList<>();
		for(Map<String, String> m : DBHandler.getInstance().retrieveAll()){
			res.add(new Product(m.get("name"),m.get("description"),Float.parseFloat(m.get("price")), Integer.parseInt(m.get("id")),Integer.parseInt(m.get("nb_prod"))));
		}
		return res;
	}


	@Override
	public void deleteEntity(int id) {
		DBHandler.getInstance().delete(id);	
	}

}
