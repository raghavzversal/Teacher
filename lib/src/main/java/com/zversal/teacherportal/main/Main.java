package com.zversal.teacherportal.main;
import static spark.Spark.path;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import java.io.IOException;
import static spark.Spark.delete;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zversal.teacherportal.controller.Controller;
import com.zversal.teacherportal.dao.Dao;
import com.zversal.teacherportal.database.ManagerDB;
import com.zversal.teacherportal.util.LoggerUtil;
import com.zversal.teacherportal.util.ReadableProperties;
import static spark.Spark.port;

public class Main {
	public static ManagerDB db = new ManagerDB();
	public static Dao teacherCrud = new Dao();
	public static ReadableProperties conArguments = new ReadableProperties();
	public static LoggerUtil record = new LoggerUtil();
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	public static void main(String[] args) throws IOException 
	{
		port(conArguments.getPort());
		path("/user", () -> 
		{
			post("/add", Controller.addByUser, gson::toJson );
			get("/find/:id", Controller.findById, gson::toJson);
			put("/update", Controller.updateByUser, gson::toJson);
			delete("/delete/:id", Controller.deleteById, gson::toJson);
         });
		
		after((req,res)->
		{
			res.type("application/json");
		});
	}

}


