package com.alma.fournisseur.domain;

import java.util.UUID;

/**
 * 
 * @author liciax
 *
 */
public class Product implements IEntity<Product> {
	
	private final UUID identifier; //put the identity in better place ?
	private String name;
	private String description;
	private int price;
	
	
	public Product(String name, String description, int price) {
		this.identifier = UUID.randomUUID();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean sameIdentityAs(Product otherEntity) {
		return otherEntity != null && this.identifier.equals(otherEntity.identifier);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj instanceof Product) {
			Product prod = (Product)obj;
			return sameIdentityAs(prod);
		}
		else return false;
	}
	
	//see in ddd sample github
//	public int hashCode() {
//		return identifier.hashCode();
//	}
}
