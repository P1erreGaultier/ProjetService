package com.alma.fournisseur.infrastructure;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.alma.fournisseur.domain.Product;

public class ProductRepositoryTest {

	ProductRepository pr;
	
	 @Before
	    public void setUp() throws Exception {
		 	pr = new ProductRepository();
	}
	
	@Test
	public void testDisplayOneProduct() {
		Product p = (Product) pr.displayOneEntity(1);
		assertTrue(p.getPrice()==7.0);
		assertTrue(p.getQuantity()==7);
	}

}
