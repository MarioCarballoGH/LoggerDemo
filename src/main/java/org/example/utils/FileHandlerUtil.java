package org.example.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

public class FileHandlerUtil {
    private String path;

    public FileHandlerUtil(String p){
        path = p;
    }

    public FileHandler getFileHandlerUtil() throws IOException {
        File logFile = new File(path + "/logFile.txt");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        return new FileHandler(path + "/logFile.txt");
    }
}
