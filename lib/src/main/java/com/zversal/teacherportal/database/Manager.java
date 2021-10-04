package com.zversal.teacherportal.database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
    public Manager()
    {
            try {

                Properties prop = loadPropertiesFile();
                String driverClass = prop.getProperty("test.jdbc.dev.driver");
                String url = prop.getProperty("test.jdbc.dev.url");
                String username = prop.getProperty("test.jdbc.dev.username");
                String password = prop.getProperty("test.jdbc.dev.password");
                Class.forName(driverClass);
                con = DriverManager.getConnection(url, username, password);
                port = Integer.parseInt(prop.getProperty("PORT"));
                }catch (SQLException e) {
                e.printStackTrace();
                } 
                catch (Exception e) {
                e.printStackTrace();
                } 
        }
    }