package org.example;

import static org.junit.Assert.assertTrue;

import org.example.model.LogLevel;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() throws Exception {
        Map<String, String> dbParams = new HashMap();
        dbParams.put("logFileFolder", "./log/");
        dbParams.put("url","jdbc:h2:./src/main/resources/default");
        dbParams.put("userName","sa");
        dbParams.put("password","sa");
        String path = "./log/";
        LogLevel[] logFilter = {LogLevel.MESSAGE, LogLevel.WARNING, LogLevel.ERROR};

        Demo demoTest = new Demo(false,false,false,logFilter,dbParams, path);
        demoTest.logMessage("Test message...", LogLevel.ERROR);
    }



}
