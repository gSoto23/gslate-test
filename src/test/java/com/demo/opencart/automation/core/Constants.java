package com.demo.opencart.automation.core;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Constants {
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/config.properties";
    private static Constants instance;
    private final Properties properties;

    private Constants() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PROPERTIES_FILE_PATH));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + PROPERTIES_FILE_PATH);
        }
    }
    public static String get(ApplicationProperty prop) {
        String p = getInstance().properties.getProperty(prop.getPropertyPath());

        if (p != null)
            return p;

        throw new RuntimeException("Property with name '" + prop.getPropertyPath() + "' not specified in the config.properties file.");
    }

    public static Boolean getAsBoolean(ApplicationProperty prop) {
        String booleanValue = get(prop);
        return Boolean.parseBoolean(booleanValue);
    }

    public static synchronized Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }
}