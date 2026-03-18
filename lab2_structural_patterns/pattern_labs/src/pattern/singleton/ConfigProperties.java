package pattern.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static ConfigProperties uniqueInstance;
    private Properties properties;

    private ConfigProperties() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("./src/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized static ConfigProperties getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ConfigProperties();
        }
        return uniqueInstance;
    }

    public Properties getProperties() {
        return properties;
    }
}
