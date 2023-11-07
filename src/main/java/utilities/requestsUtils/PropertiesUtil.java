package utilities.requestsUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    @SuppressWarnings("rawtypes")
    public static Map<String, String> createMapFromProperties(String propName) {
        Map map = loadProperties(propName);
        return (Map<String, String>) map;
    }

    public static Properties loadProperties(String propName){
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propertyPath = rootPath + propName;

        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(propertyPath));
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
