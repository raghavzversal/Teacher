package com.zversal.teacherportal.database;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariDataSource;

public class Manager
{
	public static Properties loadPropertiesFile() throws Exception {
 
        Properties prop = new Properties();
        InputStream in = new FileInputStream("database.properties");
        prop.load(in);
        in.close();
        return prop;
    }

    public Connection con = null;
    public int port = 0;
    private static HikariDataSource dataSource;
    public Manager()
    {
            try {
            	Properties prop = loadPropertiesFile();
                dataSource = new HikariDataSource();
                dataSource.setDriverClassName(prop.getProperty("test.jdbc.dev.driver"));
    			
    			dataSource.setJdbcUrl(prop.getProperty("test.jdbc.dev.url"));
    			dataSource.setUsername(prop.getProperty("test.jdbc.dev.username"));
    			dataSource.setPassword(prop.getProperty("test.jdbc.dev.password"));
                
                con = dataSource.getConnection();
                port = Integer.parseInt(prop.getProperty("PORT"));
                }catch (SQLException e) {
                e.printStackTrace();
                } 
                catch (Exception e) {
                e.printStackTrace();
                } 
        }
    }