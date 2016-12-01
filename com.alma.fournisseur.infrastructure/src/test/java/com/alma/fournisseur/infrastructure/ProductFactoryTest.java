package com.alma.fournisseur.infrastructure;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.alma.fournisseur.domain.Product;

public class ProductFactoryTest {
	
	ProductFactory factory;
	
	 @Before
	    public void setUp() throws Exception {
		factory = new ProductFactory();
	}
	
	@Test
	public void testCreate() {		
		
		Product p = (Product) factory.create("test", "description",12.3F,17,29);
		assertTrue(p.getName().equals("test"));
		assertTrue(p.getPrice()==12.3F);
		assertTrue(p.getIdentifier()==17);
		assertTrue(p.getQuantity()==29);
	}

}
