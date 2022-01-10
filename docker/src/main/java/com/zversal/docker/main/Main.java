package com.zversal.docker.main;

import static spark.Spark.*;

import com.zversal.docker.controller.Controller;

public class Main {
    public static void main(String[] args) {
        //get("/hello", (req, res) -> "Hello World");
    	port(1080);
        get("/hello", Controller.greet );
    }
}
