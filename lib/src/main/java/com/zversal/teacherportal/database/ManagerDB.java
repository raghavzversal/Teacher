package com.zversal.teacherportal.database;
import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;
//import static com.zversal.teacherportal.main.Main.conArguments;
import com.zversal.teacherportal.util.ReadableProperties;
public class ManagerDB
{
	ReadableProperties conArguments = new ReadableProperties();
	private Connection con = null;
    private static HikariDataSource dataSource;
    public ManagerDB()
    {
            try {
            	
                dataSource = new HikariDataSource();
                dataSource.setDriverClassName(conArguments.getDriverclass());
    			dataSource.setJdbcUrl( conArguments.getJdbcurl());
    			dataSource.setUsername( conArguments.getJdbcusername());
    			dataSource.setPassword(  conArguments.getJdbcpassword());
    			
   
    			this.con = dataSource.getConnection();
                }
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            } 
        }
	public Connection getConnection() 
	{
		return this.con;
	}

    
  
}