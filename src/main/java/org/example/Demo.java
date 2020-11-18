package org.example;

import org.example.model.LogLevel;
import org.example.utils.DbConnection;
import org.example.utils.FileHandlerUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    private boolean logToFile;
    private boolean logToConsole;
    private boolean logToDatabase;
    private String path;
    private Map<String, String> dbParams;
    private static Logger logger = Logger.getLogger("MyLog");
    private LogLevel[] logFilter;


    public Demo(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
                LogLevel[] logFilterParam, Map<String, String> dbParamsMap, String pathParam) {
        logToDatabase = logToDatabaseParam;
        logToFile = logToFileParam;
        logToConsole = logToConsoleParam;
        dbParams = dbParamsMap;
        path = pathParam;
        logFilter = logFilterParam;
    }

    public void logMessage(String messageText, LogLevel level) {
        messageText = messageText.trim();
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        if (!logToConsole && !logToFile && !logToDatabase) {
            throw new IllegalArgumentException("Invalid configuration");
        }
        if (logFilter.length == 0) {
            throw new IllegalArgumentException("Error or Warning or Message must be specified");
        }

        Level toLog = null;
        for (LogLevel ll: logFilter) {
            if(ll == level){
                switch(level) {
                    case MESSAGE:
                        toLog = Level.INFO;
                        break;
                    case WARNING:
                        toLog = Level.WARNING;
                        break;
                    case ERROR:
                        toLog = Level.SEVERE;
                        break;
                }
                break;
            }
        }
        if(toLog == null){
            return;
        }

        String message = DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;

        if(logToConsole){
            ConsoleHandler ch = new ConsoleHandler();
            logger.addHandler(ch);
            logger.log(toLog, message);
        }

        if(logToFile){
            FileHandlerUtil fileHandlerUtil = new FileHandlerUtil(path);
            try {
                logger.addHandler(fileHandlerUtil.getFileHandlerUtil());
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.log(toLog, message);
        }

        if(logToDatabase){
            DbConnection connection = new DbConnection(dbParams);
            Statement stmt = null;
            try {
                stmt = connection.getConection().createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Log_Values(MESSAGE VARCHAR(255), `TYPE` VARCHAR(10));");
                stmt.executeUpdate("insert into Log_Values VALUES('"+message+"','"+level+"')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
