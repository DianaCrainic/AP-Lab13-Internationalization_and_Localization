package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * CommandProp class: responsible with:
 * mapping the command names to corresponding classes using an external
 * file Commands.properties.
 */
public class CommandsProp {
    private Properties properties;

    public CommandsProp() {
        this.properties = new Properties();
        String fileName = "res/Commands.properties";
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
