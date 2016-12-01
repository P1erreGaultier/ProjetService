package com.alma.fournisseur.domain;


/**
 * 
 * @author liciax
 * An DDD entity
 */
public abstract class Entity {

	private int identifier;

	public int getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}



	/**
	 * The method compares two entities by their identifiers
	 * 
	 * @param otherEntity an entity
	 * @return true if the both entity are uniform
	 */
	public abstract boolean sameIdentityAs(Entity otherEntity);
	
}
