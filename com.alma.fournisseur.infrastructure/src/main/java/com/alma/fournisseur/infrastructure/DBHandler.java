package com.alma.fournisseur.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public static final DBHandler getInstance() {

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
			logger.warn(e);
		}
	}

	public void closeDB(){
		try {
			c.close();
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Database closed");
	}

	public void create(String name, String description, Float price, int id){
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO PRODUCT (NAME,DESCRIPTION,PRICE,ID) "+"VALUES ('"+name+"', '"+description+"', "+price+", '"+id+"');"; 
			stmt.executeUpdate(sql);
			sql = "INSERT INTO STOCK (ID,NB_PROD) "+"VALUES ('"+id+"', '0');"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
	}


	public  Map<String,String> retrieve(int id){
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
			rs = stmt.executeQuery( "SELECT NB_PROD FROM STOCK where ID="+ id +";" );
			res.put("nb_prod",Integer.toString(rs.getInt("nb_prod")));
			stmt.close();
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Operation done successfully");		 		

		return res;
	}

	public List<Map<String,String>> retrieveAll(){  
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
			logger.warn(e);
		}
		logger.info("Operation done successfully");		 		

		return res;
	}

	public void updateName(String name, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE PRODUCT set NAME="+name+" WHERE ID="+id+";"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}

	public void updateDescription(String description, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE PRODUCT set DESCRIPTION="+description+" WHERE ID="+id+";"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}

	public void updatePrice(Float price, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE PRODUCT set PRICE="+price+" WHERE ID="+id+";"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}
	
	public void updateStock(int stock, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE STOCK set NB_PROD="+stock+" WHERE ID="+id+";"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}

	
	public void delete(int id){
		try {
			stmt = c.createStatement();
			String sql = "DELETE FROM  PRODUCT WHERE ID="+id+";"; 
			stmt.executeUpdate(sql);
			sql = "DELETE FROM  STOCK WHERE ID="+id+";"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Delete done successfully");
	}

}
