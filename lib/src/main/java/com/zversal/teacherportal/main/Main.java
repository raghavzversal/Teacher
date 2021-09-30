package com.zversal.teacherportal.main;
import static spark.Spark.path;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.port;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zversal.teacherportal.controller.Controller;


public class Main {
	public static void main(String[] args) 
	{
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		path("/user", () -> 
		{
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


