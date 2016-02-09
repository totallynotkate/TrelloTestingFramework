package framework.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by totallynotkate on 07.02.16.
 * Utility class to load default application data such as default test username. Created using Singleton pattern.
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

    /**
     *
     * @return an instance of PropertyLoader which can be used to return data stored in the config file
     */
    public static PropertyLoader getInstance(){
        return INSTANCE;
    }

    /**
     * @return username from config file
     */
    public String getUsername(){
        return properties.getProperty("application_username");
    }

    /**
     * @return email from config file
     */
    public String getEmail(){
        return properties.getProperty("application_email");
    }

    /**
     * @return password from config file
     */
    public String getPassword(){
        return properties.getProperty("application_password");
    }

    /**
     * @return application starting page URL
     */
    public String getURL(){
        return properties.getProperty("site_url");
    }
}
