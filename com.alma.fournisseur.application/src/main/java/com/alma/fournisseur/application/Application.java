package com.alma.fournisseur.application;

import com.alma.fournisseur.api.IService;
import com.alma.fournisseur.domain.IFactory;
import com.alma.fournisseur.domain.IRepository;
import com.alma.fournisseur.infrastructure.ProductFactory;
import com.alma.fournisseur.infrastructure.ProductRepository;
import com.alma.fournisseur.infrastructure.Service;

public class Application {
	
	IFactory facto;
	IRepository repo;
	IService service;
	
	public Application() {
		this.facto = new ProductFactory();
		this.repo = new ProductRepository();
		this.service = new Service();
	}

	public IFactory getFacto() {
		return facto;
	}

	public IRepository getRepo() {
		return repo;
	}

	public IService getService() {
		return service;
	}
	
}
