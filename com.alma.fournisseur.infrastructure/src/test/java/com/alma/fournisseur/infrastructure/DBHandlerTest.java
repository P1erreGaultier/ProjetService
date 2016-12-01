package com.alma.fournisseur.infrastructure;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DBHandlerTest {
	
	private DBHandler instance;
	
	 @Before
	    public void setUp() throws Exception {
		 instance = DBHandler.getInstance();
		 instance.openDB();
	}
	
	@Test
	public void testGetInstance() {
	      assertTrue(instance != null);
	}


	@Test
	public void testRetrieve() {
		Map<String, String> m= DBHandler.getInstance().retrieve(1);
		assertTrue(m.get("price").equals("7.0"));
		assertTrue(m.get("nb_prod").equals("7"));
	}

	@Test
	public void testCreate() {
		DBHandler.getInstance().create("test", "description",(float) 12.3,17,29);
		Map<String, String> m=DBHandler.getInstance().retrieve(17);
		assertTrue(m.get("name").equals("test"));
		assertTrue(m.get("price").equals("12.3"));
		assertTrue(m.get("id").equals("17"));
		assertTrue(m.get("nb_prod").equals("29"));
		DBHandler.getInstance().delete(17);
	}
}
