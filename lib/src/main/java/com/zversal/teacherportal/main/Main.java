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
import com.zversal.teacherportal.database.Manager;

import static spark.Spark.port;

public class Main {
	public static Manager getPort = new Manager();
	public static void main(String[] args) throws IOException 
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		path("/user", () -> 
		{
			port(getPort.port);
			post("/add", Controller.add, gson::toJson );
			get("/find/:id", Controller.find, gson::toJson);
			put("/update", Controller.update, gson::toJson);
			delete("/delete/:id", Controller.delete, gson::toJson);
         });
		
		after((req,res)->
		{
			res.type("application/json");
		});
	}

}


