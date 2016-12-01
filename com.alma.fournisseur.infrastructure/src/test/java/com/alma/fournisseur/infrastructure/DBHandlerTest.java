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
	}
	
	@Test
	public void testGetInstance() {
	      assertTrue(instance != null);
	}


	@Test
	public void testRetrieve() {
		Map<String, String> m= DBHandler.getInstance().retrieve(1);
		assertTrue(m.get("name").equals("LITI�RE � LA FEVE DE CAF� TONIFIANTE ET � LA PAPAYE DU BRESIL"));
		assertTrue(m.get("price").equals("7"));
		assertTrue(m.get("nb_prod").equals("7"));
	}

}
