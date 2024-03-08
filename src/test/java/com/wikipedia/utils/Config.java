package com.wikipedia.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private final Properties properties;
    String path = "./src/test/resources/config.properties";

    public Config() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBrowserName() {
        return properties.getProperty("browserName");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getDownloadDir() {
        return System.getProperty("user.dir") + properties.getProperty("downloadDir");
    }
    public String getLanguage(){
        return  properties.getProperty("language").trim();
    }

    public String getQuery() {
        return properties.getProperty("query").trim();
    }

    public String getPdfName() {
        return  properties.getProperty("pdf").trim();
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

