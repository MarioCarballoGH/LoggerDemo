package org.example;

import org.example.model.LogLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Map<String, String> dbParams = new HashMap();
        dbParams.put("logFileFolder", "./log/");
        dbParams.put("url","jdbc:h2:./src/main/resources/default");
        dbParams.put("userName","sa");
        dbParams.put("password","sa");
        String path = "./log/";
        LogLevel[] logFilter = {LogLevel.MESSAGE, LogLevel.WARNING, LogLevel.ERROR};

        Demo demoTest = new Demo(true,true,true,logFilter,dbParams, path);
        demoTest.logMessage("Log message...", LogLevel.ERROR);
    }
}
