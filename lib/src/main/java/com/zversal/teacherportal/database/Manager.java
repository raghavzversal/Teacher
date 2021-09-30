package com.zversal.teacherportal.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Manager {
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "raghav";
    static final String PASS = "1234";
    public static Connection con = null;
    
    
    public Connection getConnection() throws SQLException {
    	return con = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    
	

}
