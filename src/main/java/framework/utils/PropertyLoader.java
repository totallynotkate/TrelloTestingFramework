package framework.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class PropertyLoader {
    private static final String PROPERTIES_FILE = "/config.properties";
    private static final PropertyLoader INSTANCE = new PropertyLoader();
    private final Properties properties;

    private PropertyLoader(){
        this.properties = new Properties();
        try {
            properties.load(PropertyLoader.class.getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties file could not be loaded from " + PROPERTIES_FILE);
        }
    }

    public static PropertyLoader getInstance(){
        return INSTANCE;
    }

    public String getUsername(){
        return properties.getProperty("application_username");
    }

    public String getEmail(){
        return properties.getProperty("application_email");
    }

    public String getPassword(){
        return properties.getProperty("application_password");
    }

    public String getURL(){
        return properties.getProperty("site_url");
    }
}
