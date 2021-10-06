package com.zversal.teacherportal.controller;
import java.util.HashMap;
import java.util.logging.Level;

import com.zversal.teacherportal.util.LoggerUtil;

import static com.zversal.teacherportal.main.Main.gson;
import static com.zversal.teacherportal.main.Main.teacherCrud;



import spark.Route;
public class Controller {
	
	public static final Route findById = (req,res)->
	{
		
		LoggerUtil.logger.info("Finding By Id");
		HashMap<String, Object> map = new HashMap<>();
		try 
		{
			
			String uid = req.params("id");
			int id = Integer.parseInt(uid);
			map = teacherCrud.searchById(id);
			LoggerUtil.logger.log(Level.INFO,"Went well");
			return map;
			
		}
		catch(Exception e)
		{
			map.put("Read", "Failed" );
			LoggerUtil.logger.log(Level.WARNING,"::Exception::"+e);
			return map;
		}
		
	};
	
	public static final Route addByUser = (req,res)->
	{
		
		LoggerUtil.logger.info("Adding a user");
		HashMap<String, String> map = new HashMap<>();
		try 
		{
			
			String val = req.body();
			HashMap<String, String> teacherDetails = gson.fromJson(val, HashMap.class);
			map.put("Insertion:", teacherCrud.addByUser(Integer.parseInt(teacherDetails.get("id")), teacherDetails.get("name"), teacherDetails.get("department")));
			LoggerUtil.logger.log(Level.INFO,"Went well");
			return map;
		 }
		catch(Exception e) 
		{
			//logger.log(Level.WARNING,"::Exception::"+e);
			map.put("Insertion:", "Failed");
			LoggerUtil.logger.log(Level.WARNING,"::Exception::"+e);
			return map;
		}
		     
			 
	 };
	 
		public static final Route updateByUser = (req,res)->
		{
			
			LoggerUtil.logger.info("Updating user");
			HashMap<String, String> map = new HashMap<>(); 
			try 
			{
				
				String val = req.body();
				HashMap<String, String> teacherDetails = gson.fromJson(val, HashMap.class);
				map.put("Updation", teacherCrud.updateByUser(Integer.parseInt(teacherDetails.get("id")), teacherDetails.get("name"), teacherDetails.get("department")));
				LoggerUtil.logger.log(Level.INFO,"Went well");
				return map;
			}
			catch(Exception e ) 
			{
				//logger.log(Level.WARNING,"::Exception::"+e);
				map.put("Updation:", "Failed");
				LoggerUtil.logger.log(Level.WARNING,"::Exception::"+e);
				return map;
			}
			
		};
		
		 public static final Route deleteById = (req,res)->
		 {
			 
			 LoggerUtil.logger.info("Deletion by id");
			 HashMap<String, String> map = new HashMap<>(); 
			 try {
				 	
				    String uid = req.params("id");
		    		int id = Integer.parseInt(uid);
		            map.put("Deletion", teacherCrud.deleteById(id));
		            LoggerUtil.logger.log(Level.INFO,"Went well");
		            return map;
		    	 }
		    catch(Exception e) 
			 {
		    	 //logger.log(Level.WARNING,"::Exception::"+e);
		    	map.put("Deletion:", "Failed");
		    	LoggerUtil.logger.log(Level.WARNING,"::Exception::"+e);
				return map;
		     }
			 
		 };
		 
		 
	 
	 
	
	
	
	
	

}
