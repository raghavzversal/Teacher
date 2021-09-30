package com.zversal.teacherportal.controller;
import java.util.HashMap;

import org.checkerframework.checker.formatter.qual.ReturnsFormat;

import com.google.gson.Gson;
import com.zversal.teacherportal.dao.Dao;

import spark.Route;
public class Controller {
    public static final Dao teacher_crud = new Dao();
    public static Gson gson = new Gson();
	static HashMap<String, Object> map = new HashMap<>();
	
	
	public static final Route find = (req,res)->
	{
		try 
		{
			String uid = req.params("id");
			int id = Integer.parseInt(uid);
			map = teacher_crud.findDB(id);
			return map;
		}
		catch(Exception e)
		{
		  map.put("Error:", "Kindly check the entered id" );
		  return map;
		}
		
	};
	public static final Route add = (req,res)->
	{
		try 
		{
			String val = req.body();
			map = teacher_crud.Convert(val);
			
			int id = (int) map.get("id");
			String name = (String) map.get("name");
			String department = (String) map.get("department");
			map.put("Result", teacher_crud.AddUser(id, name, department));
			return map;
		 }
		catch(Exception e) 
		{
			map.put("Error:", "Kindly check the entered data" );
			return map;
		}
		     
			 
	 };
	 
		public static final Route update = (req,res)->
		{
			try 
			{
				String val = req.body();
				map = teacher_crud.Convert(val);
				
				int id = (int) map.get("id");
				String name = (String) map.get("name");
				String department = (String) map.get("department");
				map.put("Result", teacher_crud.UpdateUser(id, name, department));
				return map;
			}
			catch(Exception e ) 
			{
				map.put("Error:", "Kindly check the entered data" );
				return map;
			}
			
		};
		
		 public static final Route delete = (req,res)->
		 {
			 try {
				    String uid = req.params("id");
		    		int id = Integer.parseInt(uid);
		            map.put("Result", teacher_crud.DeleteUser(id));  
		            return map;
		    	 }
		    catch(Exception e) 
			 {
		         map.put("Error","Kindly check the entered id");
		         return map;
		     }
			 
		 };
		 
		 
	 
	 
	
	
	
	
	

}
