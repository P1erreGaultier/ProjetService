package com.alma.fournisseur.domain;

/**
 * 
 * @author liciax
 *
 */
public class Product extends Entity {
	
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public Product(String name, String description, double d) {
		super();
		this.name = name;
		this.description = description;
		this.price = d;
		this.quantity = 0;
		
	}
	
	public Product(String name, String description, double d, int id, int q) {
		super();
		this.name = name;
		this.description = description;
		this.price = d;
		this.quantity = q;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean sameIdentityAs(Entity otherEntity) {
		return otherEntity != null && getIdentifier()==(otherEntity.getIdentifier());
	}
	
	@Override
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
		return "Product [identifier=" + getIdentifier() + ", name=" + name + ", description=" + description + ", price="
				+ price + "quantity=" + quantity + "]";
	}
	
	@Override
	public int hashCode() {
		return getIdentifier();
	}
}
