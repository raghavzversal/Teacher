package com.zversal.teacherportal.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zversal.teacherportal.database.Manager;

public class Dao {
	
	public final static Manager db_connection = new Manager(); 
	public final static HashMap<String, Object> map = new HashMap<>();
	
	public HashMap<String, Object> Convert(Object udata){
		JsonObject data = new JsonParser().parse((String) udata).getAsJsonObject();
		JsonElement uid =  data.get("id");
		JsonElement uname = data.get("name");
		JsonElement udepartment = data.get("department");
		map.put("id", uid.getAsInt());
		map.put("name", uname.getAsString());
		map.put("department", udepartment.getAsString());
		return map;
	}
	
	public HashMap<String, Object> findDB(int id)
	{ 
    	
    	try 
    	{
       	 
            if(db_connection.getConnection()!=null)
            {
                PreparedStatement stat = db_connection.getConnection().prepareStatement("select t_id, t_name, t_department from demo where t_id=?");
                stat.setInt(1, id);
                ResultSet set = stat.executeQuery();
                
                if(set.next())
                {
                    map.put("id",set.getInt("t_id"));
                    map.put("name",set.getString("t_name"));
                    map.put("department",set.getString("t_department"));
                    return map;
                }
            }
       }  
       catch(Exception e) 
    	{
       		map.put("Error", e);
       		return map;
        }
		return null;
		
		
    	
    	
    }

	public String AddUser(int id, String name, String department)
	{ 
    	
    	try 
    	{
       	 
            if(db_connection.getConnection()!=null)
            {
            	PreparedStatement stat = db_connection.getConnection().prepareStatement("insert into demo values(?,?,?) ");
                stat.setInt(1, id);
                stat.setString(2, name);
                stat.setString(3, department);
                stat.executeUpdate();
                return "Insertion went well";
            }
       }  
       catch(Exception e) 
    	{
       		return "Kindly check the values entered";
        }
		return"Kindly check the values entered";
		
	}


	public String UpdateUser(int id, String name, String department)
	{ 
    	
    	try 
    	{
       	 
            if(db_connection.getConnection()!=null)
            {
            	PreparedStatement stat = db_connection.getConnection().prepareStatement(" update demo set t_name=?, t_department=? where t_id =? ");
                stat.setInt(3, id);
                stat.setString(1, name);
                stat.setString(2, department);
                stat.executeUpdate();
                return "Updation Successful";
            }
       }  
       catch(Exception e) 
    	{
       		return "Kindly check the values entered";
        }
		return"Kindly check the values entered";
		
	}
	
	public String DeleteUser(int id) 
	{
		try 
		{
			PreparedStatement stat = db_connection.getConnection().prepareStatement(" delete from demo where t_id=? ");
	        stat.setInt(1, id);
	        stat.executeUpdate();
	        return "Deletion Successful";
	              
		}
	 
   catch(Exception e) 
	{
   		return "Kindly check the id entered";
    }
	
	} 



}
	


