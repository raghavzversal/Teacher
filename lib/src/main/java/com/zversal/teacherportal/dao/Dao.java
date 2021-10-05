package com.zversal.teacherportal.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import static com.zversal.teacherportal.main.Main.db;

public class Dao {

	public HashMap<String, Object> searchById(int id)
	{ 
    	HashMap<String, Object> map = new HashMap<>();
    	try 
    	{
            if(db.getConnection()!=null)
            {
                PreparedStatement stat = db.getConnection().prepareStatement("select t_id, t_name, t_department from demo where t_id=?");
                stat.setInt(1, id);
                ResultSet set = stat.executeQuery();
                
                if(set.next())
                {
                    map.put("id", set.getInt("t_id"));
                    map.put("name", set.getString("t_name"));
                    map.put("department", set.getString("t_department"));
                    return map;
                    
                }
            }
       }  
       catch(Exception e) 
    	{
       		map.put("Error", "Check entered values");
       		return map;
        }
    	map.put("Error", "Contact Developer");
   		return map;
		
		
    	
    	
    }

	public String addByUser(int id, String name, String department)
	{ 
    	
    	try 
    	{
       	 
            if(db.getConnection()!=null)
            {
            	PreparedStatement stat = db.getConnection().prepareStatement("insert into demo values(?,?,?) ");
                stat.setInt(1, id);
                stat.setString(2, name);
                stat.setString(3, department);
                stat.executeUpdate();
                return "Successful";
            }
       }  
       catch(Exception e) 
    	{
       		return "Kindly check the values entered";
        }
		return"Contact Developer";
		
	}


	public String updateByUser(int id, String name, String department)
	{ 
    	
    	try 
    	{
       	 
            if(db.getConnection()!=null)
            {
            	PreparedStatement stat = db.getConnection().prepareStatement(" update demo set t_name=?, t_department=? where t_id =? ");
                stat.setInt(3, id);
                stat.setString(1, name);
                stat.setString(2, department);
                stat.executeUpdate();
                return "Successful";
            }
       }  
       catch(Exception e) 
    	{
       		return "Kindly check the values entered";
        }
		return"Contact Developer";
		
	}
	
	public String deleteById(int id) 
	{
		try 
		{
			if(db.getConnection()!=null) 
			{
			PreparedStatement stat = db.getConnection().prepareStatement(" delete from demo where t_id=? ");
	        stat.setInt(1, id);
	        stat.executeUpdate();
	        return "Successful";
			}
	              
		}
	 
   catch(Exception e) 
	{
   		return "Kindly check the id entered";
    }
		return "Contact Developer";
   		
	
	} 



}
	


