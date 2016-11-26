package com.alma.fournisseur.domain;

import java.util.UUID;

/**
 * 
 * @author liciax
 * An DDD entity
 */
public abstract class Entity {

	private UUID identifier;
	
	
	public UUID getIdentifier() {
		return identifier;
	}

	public void setIdentifier(UUID identifier) {
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
