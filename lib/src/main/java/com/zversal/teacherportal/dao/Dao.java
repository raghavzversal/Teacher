package com.zversal.teacherportal.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.zversal.teacherportal.database.Manager;

public class Dao {
	
	public final static Manager db = new Manager(); 
	public final static HashMap<String, Object> map = new HashMap<>();
	
	
	public HashMap<String, Object> search(int id)
	{ 
    	
    	try 
    	{
            if(db.con!=null)
            {
                PreparedStatement stat = db.con.prepareStatement("select t_id, t_name, t_department from demo where t_id=?");
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
       		map.put("Error", "Kindly check entered id");
       		return map;
        }
    	map.put("Error", "Kindly check entered id");
   		return map;
		
		
    	
    	
    }

	public String add(int id, String name, String department)
	{ 
    	
    	try 
    	{
       	 
            if(db.con!=null)
            {
            	PreparedStatement stat = db.con.prepareStatement("insert into demo values(?,?,?) ");
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


	public String update(int id, String name, String department)
	{ 
    	
    	try 
    	{
       	 
            if(db.con!=null)
            {
            	PreparedStatement stat = db.con.prepareStatement(" update demo set t_name=?, t_department=? where t_id =? ");
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
	
	public String delete(int id) 
	{
		try 
		{
			if(db.con!=null) 
			{
			PreparedStatement stat = db.con.prepareStatement(" delete from demo where t_id=? ");
	        stat.setInt(1, id);
	        stat.executeUpdate();
	        return "Deletion Successful";
			}
	              
		}
	 
   catch(Exception e) 
	{
   		return "Kindly check the id entered";
    }
		return "Kindly check entered id";
   		
	
	} 



}
	


