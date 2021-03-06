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
	Statement stmtStock = null;
	Connection c = null;

	/**
	 *  Singleton
	 */
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

	/**
	 * Open Database Connection
	 */
	public void openDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Pierre/git/ProjetService/com.alma.fournisseur.infrastructure/db_tab1.sqlite");
			c.setAutoCommit(false);
			logger.info("Opened database successfully");
		} catch ( Exception e ) {
			logger.warn(e);
		}
	}

	/**
	 * Close Database Connection
	 */
	public void closeDB(){
		try {
			c.close();
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Database closed");
	}

	/**
	 * Create a product and save it in the database
	 * @param name
	 * @param description
	 * @param price
	 * @param id
	 */
	public void create(String name, String description, Float price, int id, int nbStock){
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO PRODUCT (NAME,DESCRIPTION,PRICE,ID) "+"VALUES ('"+name+"', '"+description+"', "+price+", '"+id+"');"; 
			stmt.executeUpdate(sql);
			sql = "INSERT INTO STOCK (ID,NB_PROD) "+"VALUES ('"+id+"', '"+nbStock+"');"; 
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
	}

	/**
	 * retrieve a product by ID
	 * @param id
	 * @return Map<String,String>
	 */
	public  Map<String,String> retrieve(int id){
		Map<String,String> res = new HashMap<>();		    		 
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

	/**
	 * retrieve all products
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> retrieveAll(){  
		ArrayList<Map<String,String>> res = new ArrayList<>();
		Map<String,String> tupple;	  
		try{
			stmt = c.createStatement();
			stmtStock = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT;" );
			while ( rs.next() ) {
				tupple = new HashMap<>();	
				tupple.put("name",rs.getString("name"));
				tupple.put("description",rs.getString("description"));
				tupple.put("price",Float.toString(rs.getFloat("price")));
				tupple.put("id",Integer.toString(rs.getInt("id")));
				ResultSet rsStock = stmtStock.executeQuery( "SELECT NB_PROD FROM STOCK where ID="+ rs.getInt("id") +";" );
				tupple.put("nb_prod",Integer.toString(rsStock.getInt("nb_prod")));
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

	/**
	 * update the name of a product
	 * @param name
	 * @param id
	 **/
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

	/**
	 * update the description of a product
	 * @param description
	 * @param id
	 **/
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

	/**
	 * update the price of a product
	 * @param price
	 * @param id
	 **/
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
	
	/**
	 * update the stock of a product
	 * @param stock
	 * @param id
	 **/
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

	/**
	 * delete a product
	 * @param id
	 **/
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
