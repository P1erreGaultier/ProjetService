package com.alma.fournisseur.domain;

/**
 * 
 * @author liciax
 *
 */
public class Product extends Entity {
	
	private String name;
	private String description;
	private float price;
	private int quantity;
	
	
	public Product(String name, String description, float price, int id, int q) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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
		return otherEntity != null && getIdentifier().equals(otherEntity.getIdentifier());
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
				+ price + "]";
	}
	
	@Override
	public int hashCode() {
		return getIdentifier().hashCode();
	}
	
}
