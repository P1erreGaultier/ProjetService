package com.alma.fournisseur.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.alma.fournisseur.domain.IEntity;

public class main {

	public static void main(String[] args) {
		Infrastruture i = new Infrastruture();
		List<IEntity> a = i.getAllProduct();
		for(IEntity p : a){
			System.out.println(p.toString());
		}
	}

}
