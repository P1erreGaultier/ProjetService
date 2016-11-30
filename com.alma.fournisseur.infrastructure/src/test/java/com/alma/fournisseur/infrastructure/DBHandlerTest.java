package com.alma.fournisseur.infrastructure;

import static org.junit.Assert.*;

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
		DBHandler otherInstance = DBHandler.getInstance();
		assertSame(instance, otherInstance);
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieve() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
