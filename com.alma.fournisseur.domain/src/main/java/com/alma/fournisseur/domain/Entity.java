package com.alma.fournisseur.domain;

import java.util.UUID;

/**
 * 
 * @author liciax
 * An DDD entity
 */
public abstract class Entity {

	private int identifier = UUID.randomUUID().hashCode();

	public int getIdentifier() {
		return identifier;
	}

	/**
	 * The method compares two entities by their identifiers
	 * 
	 * @param otherEntity an entity
	 * @return true if the both entity are uniform
	 */
	public abstract boolean sameIdentityAs(Entity otherEntity);
	
}
