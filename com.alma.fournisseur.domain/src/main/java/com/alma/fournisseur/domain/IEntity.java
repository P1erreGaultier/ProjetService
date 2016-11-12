package com.alma.fournisseur.domain;

/**
 * 
 * @author liciax
 * An DDD entity
 * @param <T>
 */
public interface IEntity<T> {
	
	/**
	 * The method compares two entities by their identifiers
	 * 
	 * @param otherEntity an entity
	 * @return true if the both entity are uniform
	 */
	public boolean sameIdentityAs(T otherEntity);
	
}
