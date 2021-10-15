package testdb;

import java.sql.*;    
public class JdbcTest {
	
  private final static String DB_URL = "jdbc:postgresql://localhost:5432/";
  private final static String USER = "postgres";
  private final static String PASS = "admin";

  public static void main(String[] args) {
    Connection conn = null;  
    try {    
      Class.forName("oracle.jdbc.OracleDriver");    
      System.out.println("Connecting to database...");    
      conn = DriverManager.getConnection(DB_URL,USER,PASS);    
    } catch (Exception e) {    
      e.printStackTrace();    
    } finally {    
      if (conn != null) {    
        try {    
          conn.close();    
        } catch (SQLException e) {    
          // ignore    
        }    
      }    
    }            
  }    
}