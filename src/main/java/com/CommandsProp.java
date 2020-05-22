package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandsProp {
    private Properties properties;

    public CommandsProp() {
        this.properties = new Properties();
        String fileName = "Commands.properties";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyName(String key) {
        return this.properties.getProperty(key);
    }

}