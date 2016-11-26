package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.alma.fournisseur.domain.Entity;

public class main {

	public static void main(String[] args) {
		Infrastruture i = new Infrastruture();
		List<Entity> a = i.getAllProduct();
		for(Entity p : a){
			System.out.println(p.toString());
		}
	}

}
