package com.saucedemo.utils;

import java.io.IOException;
import java.util.Properties;

public class EnvUtils {

    private Properties prop;
    public static EnvUtils envUtils;

    private EnvUtils() throws IOException {
        String env = System.getProperty("env", "STAGING");
        switch (env){
            case "PRODUCTION" -> {
                prop =  ConfigUtil.readConfig("src/test/resources/properties/production.properties");
            }
            case "STAGING" -> {
                prop =  ConfigUtil.readConfig("src/test/resources/properties/staging.properties");
            }
            case "LOCAL" -> {
                prop = ConfigUtil.readConfig("src/test/resources/properties/local.properties");
            }
            default -> {
                throw new RuntimeException("Umgebung ist nicht Verfügbar");
            }
        }
    }
    public static EnvUtils getInstance() throws IOException {
        envUtils = new EnvUtils();
        return envUtils;
    }
    public String getURL(){
        return prop.get("URL").toString();
    }
    public String getUser(){
        return prop.get("USER").toString();
    }
    public String getPassword(){
        return prop.get("PASSWORD").toString();
    }

}
