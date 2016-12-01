package com.alma.fournisseur.infrastructure;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

public class ProductFactoryTest {
	
	ProductFactory factory;
	
	 @Before
	    public void setUp() throws Exception {
		factory = new ProductFactory();
	}
	
	@Test
	public void testCreate() {
		factory.create("test", "description",(float) 12.3,17,29);
		Map<String, String> m=DBHandler.getInstance().retrieve(17);
		assertTrue(m.get("name").equals("test"));
		assertTrue(m.get("price").equals("12.3"));
		assertTrue(m.get("id").equals("17"));
		assertTrue(m.get("nb_prod").equals("29"));
		DBHandler.getInstance().delete(17);
	}

}
