package com.zversal.teacherportal.util;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggerUtil {
	
		public static Logger logger = Logger.getLogger("log.txt");
	    public static void init()
	    {
	        FileHandler fh;
	        try
	        {
	            fh=new FileHandler("log.txt");
	            logger.addHandler(fh);
	            logger.info("init");
	        }
	        catch(Exception e)
	        {
	            logger.log(Level.WARNING,"::Exception::"+e);

	        }
	    }

}

