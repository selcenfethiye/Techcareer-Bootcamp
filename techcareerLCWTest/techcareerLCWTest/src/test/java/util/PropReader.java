package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
    private static Properties properties;

    static {
        final String PROP_FILE_PATH = "src/test/resources/test.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(PROP_FILE_PATH);
            properties = new Properties();

            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
