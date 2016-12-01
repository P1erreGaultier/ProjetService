package com.alma.fournisseur.infrastructure;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.alma.fournisseur.application.Application;
import com.alma.fournisseur.domain.Product;

public class ApplicationTest {

	Application app;
	
	 @Before
	public void setUp() throws Exception {
		 	app = new Application();
	}
	
	@Test
	public void testDisplayOneProduct() {
		Product p = (Product) app.getRepo().displayOneEntity(1);
		assertTrue(p.getPrice()==12.3f);
		assertTrue(p.getQuantity()==1);
	}

}
