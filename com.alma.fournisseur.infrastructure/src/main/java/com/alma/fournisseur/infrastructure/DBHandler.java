package com.alma.fournisseur.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBHandler {

	public  Map<String,String> getProductInDatabase(int id){
		
		
		    Connection c = null;
		    Statement stmt = null;
		   
		    Map<String,String> res = new HashMap<String,String>();
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:db_tab1.sqlite");
		      c.setAutoCommit(false);
		      //logger.info(("Opened database successfully");
		      
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT where ID="+ id +";" );
		      while ( rs.next() ) {

		          res.put("name",rs.getString("name"));
		          res.put("description",rs.getString("description"));
		          res.put("price",Float.toString(rs.getFloat("price")));
		          res.put("name",Integer.toString(rs.getInt("id")));

		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		  //logger.info("Operation done successfully");		 		
		
		return res;
	}
	
}
