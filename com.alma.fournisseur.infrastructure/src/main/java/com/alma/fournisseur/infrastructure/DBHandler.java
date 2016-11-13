package com.alma.fournisseur.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public final class DBHandler {
	
	private static volatile DBHandler instance = null;
	private static final Logger logger = Logger.getLogger(DBHandler.class);
	Statement stmt = null;
	Connection c = null;
	
    private DBHandler() {
        super();
    }
    
    public final static DBHandler getInstance() {

        if (DBHandler.instance == null) {
           synchronized(DBHandler.class) {
             if (DBHandler.instance == null) {
            	 DBHandler.instance = new DBHandler();
             }
           }
        }
        return DBHandler.instance;
    }
	
    
    public void openDB(){
    	try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:db_tab1.sqlite");
		      c.setAutoCommit(false);
		      logger.info("Opened database successfully");
    	} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
    }
    
    public void closeDB(){
    	try {
			c.close();
	    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
    	logger.info("Database closed");
    }

    
    
	public  Map<String,String> getProductInDatabase(int id){
		   
		    Map<String,String> res = new HashMap<String,String>();		    		 
		    try{
		    stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT where ID="+ id +";" );
		    while ( rs.next() ) {
		        res.put("name",rs.getString("name"));
		        res.put("description",rs.getString("description"));
		        res.put("price",Float.toString(rs.getFloat("price")));
		        res.put("id",Integer.toString(rs.getInt("id")));
		      }
		      rs.close();
		      stmt.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		  logger.info("Operation done successfully");		 		
		
		return res;
	}
	
	
	public  ArrayList<Map<String,String>> getProductInDatabase(){
		   
		ArrayList<Map<String,String>> res = new ArrayList<Map<String,String>>();
		Map<String,String> tupple;	  
	    try{
	    stmt = c.createStatement();
	    ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT;" );
	    while ( rs.next() ) {
	    	tupple = new HashMap<String,String>();	
	    	tupple.put("name",rs.getString("name"));
	    	tupple.put("description",rs.getString("description"));
	    	tupple.put("price",Float.toString(rs.getFloat("price")));
	    	tupple.put("id",Integer.toString(rs.getInt("id")));
	    	res.add(tupple);
	      }
	      rs.close();
	      stmt.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	  logger.info("Operation done successfully");		 		
	
	return res;
	}
		
}
