package concepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static final String TEST_ENV ="TEST_ENV" ;
    private Properties properties;

    public configReader() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/test/java/config/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();

        }


    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    public String getURL(){
    String env = System.getenv(TEST_ENV);
        if (env == null) {
            throw new IllegalStateException("Environment variable TEST_ENV is not set");
        }
        String url = properties.getProperty(env);
        if (url == null) {
            throw new IllegalArgumentException("No URL found for environment: " + env);
        }
        return url;

    }
}