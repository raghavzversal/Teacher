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
			map = main.teacherCrud.search(id);
			return map;
		}
		catch(Exception e)
		{
		  logger.log(Level.WARNING,"::Exception::"+e);
		  map.put("Error:", "Kindly check the entered id" );
		  return map;
		}
		
	};
	public static final Route add = (req,res)->
	{
		  init();
		try 
		{
			String val = req.body();
			Controller format = gson.fromJson(val, Controller.class);
			map.put("Operation",main.teacherCrud.add(format.id, format.name, format.department));
			return map;
		 }
		catch(Exception e) 
		{
			logger.log(Level.WARNING,"::Exception::"+e);
			map.put("Error:", "Kindly check the entered data" );
			return map;
		}
		     
			 
	 };
	 
		public static final Route update = (req,res)->
		{
			  init();
			try 
			{
				String val = req.body();
				Controller format = gson.fromJson(val, Controller.class);
				map.put("Operation", main.teacherCrud.update(format.id, format.name, format.department));
				return map;
			}
			catch(Exception e ) 
			{
				logger.log(Level.WARNING,"::Exception::"+e);
				map.put("Error:", "Kindly check the entered data" );
				return map;
			}
			
		};
		
		 public static final Route delete = (req,res)->
		 {
			  init();
			 try {
				    String uid = req.params("id");
		    		int id = Integer.parseInt(uid);
		            map.put("Operation", main.teacherCrud.delete(id));  
		            return map;
		    	 }
		    catch(Exception e) 
			 {
		    	logger.log(Level.WARNING,"::Exception::"+e);
		         map.put("Error","Kindly check the entered id");
		         return map;
		     }
			 
		 };
		 
		 
	 
	 
	
	
	
	
	

}
