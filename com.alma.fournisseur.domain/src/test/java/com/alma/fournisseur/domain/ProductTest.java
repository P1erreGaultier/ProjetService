package com.alma.fournisseur.domain;

import static org.junit.Assert.*;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ProductTest {

	private final Class<?> prod = Product.class;
	
	@Test
    public void testPojoMethods() {
        assertPojoMethodsFor(prod).testing(Method.GETTER, Method.SETTER).areWellImplemented();
}
	
	@Test
	public void testSameIdentityAs() {
		Product prod1 = new Product("litiere1", "un produit test num 1", (float) 5.5);
		Product prod2 = new Product("litiere2", "un produit test num 2", (float) 3.2);
		assertFalse(prod1.sameIdentityAs(prod2));
		assertTrue(prod1.sameIdentityAs(prod1));
	}

	@Test
	public void testEqualsObject() {
		assertPojoMethodsFor(prod).testing(Method.EQUALS).areWellImplemented();
	}

	@Test
	public void testToString() {
		assertPojoMethodsFor(prod).testing(Method.TO_STRING).areWellImplemented();
	}

}
