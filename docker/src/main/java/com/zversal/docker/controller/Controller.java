package com.zversal.docker.controller;

import spark.Route;
public class Controller {
public static final Route greet = (req,res)->
{
	try 
	{
		return "Hello world";
	}
	catch(Exception e)
	{
		return e;
	}
	
};
}
