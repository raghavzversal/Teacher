package com.zversal.teacherportal.controller;
import java.util.HashMap;
import com.google.gson.Gson;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.zversal.teacherportal.main.Main;


import spark.Route;
public class Controller {
	public int id = 0;
    public String name = null;
    public String department = null;
	public static Main main = new Main();
    public static Gson gson = new Gson();
	static HashMap<String, Object> map = new HashMap<>();
	private static Logger logger = Logger.getLogger("log.txt");
	
    public static void init(){
        FileHandler fh;
        try{
            fh=new FileHandler("log.txt");
            logger.addHandler(fh);
            logger.info("init");
        }
        catch(Exception e){
            logger.log(Level.WARNING,"::Exception::"+e);

        }
    }
	
	public static final Route find = (req,res)->
	{
		  init();
		try 
		{
			String uid = req.params("id");
			int id = Integer.parseInt(uid);
			map.put("Data", main.teacherCrud.search(id));
			return map.get("Data");
		}
		catch(Exception e)
		{
		  logger.log(Level.WARNING,"::Exception::"+e);
		  map.put("Get Error", "Kindly check the entered id" );
		  return map.get("Get Error");
		}
		
	};
	public static final Route add = (req,res)->
	{
		  init();
		try 
		{
			String val = req.body();
			Controller format = gson.fromJson(val, Controller.class);
			map.put("Insertion",main.teacherCrud.add(format.id, format.name, format.department));
			return map.get("Insertion");
		 }
		catch(Exception e) 
		{
			logger.log(Level.WARNING,"::Exception::"+e);
			map.put("Insertion error", "Kindly check the entered data" );
			return map.get("Insertion error");
		}
		     
			 
	 };
	 
		public static final Route update = (req,res)->
		{
			  init();
			try 
			{
				String val = req.body();
				Controller format = gson.fromJson(val, Controller.class);
				map.put("Updation", main.teacherCrud.update(format.id, format.name, format.department));
				return map.get("Updation");
			}
			catch(Exception e ) 
			{
				logger.log(Level.WARNING,"::Exception::"+e);
				map.put("Updation error", "Kindly check the entered data" );
				return map.get("Updation error");
			}
			
		};
		
		 public static final Route delete = (req,res)->
		 {
			  init();
			 try {
				    String uid = req.params("id");
		    		int id = Integer.parseInt(uid);
		            map.put("Deletion", main.teacherCrud.delete(id));  
		            return map.get("Deletion");
		    	 }
		    catch(Exception e) 
			 {
		    	logger.log(Level.WARNING,"::Exception::"+e);
		         map.put("Deletion error","Kindly check the entered id");
		         return map.get("Deletion error");
		     }
			 
		 };
		 
		 
	 
	 
	
	
	
	
	

}
