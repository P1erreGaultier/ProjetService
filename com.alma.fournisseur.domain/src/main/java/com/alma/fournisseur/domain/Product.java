package com.alma.fournisseur.domain;

import java.util.UUID;

/**
 * 
 * @author liciax
 *
 */
public class Product implements IEntity<Product> {
	
	private final int identifier;
	private String name;
	private String description;
	private float price;
	
	
	public Product(String name, String description, float price,int id) {
		this.identifier = id;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean sameIdentityAs(Product otherEntity) {
		return otherEntity != null && this.identifier==otherEntity.identifier;
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

	@Override
	public String toString() {
		return "Product [identifier=" + identifier + ", name=" + name + ", description=" + description + ", price="
				+ price + "]";
	}
	
	
	
	//see in ddd sample github
//	public int hashCode() {
//		return identifier.hashCode();
//	}
}
