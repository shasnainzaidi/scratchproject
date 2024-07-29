package concepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {
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
}