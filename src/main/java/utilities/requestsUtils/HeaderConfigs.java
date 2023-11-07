package utilities.requestsUtils;

import java.util.HashMap;
import java.util.Map;

import static utilities.requestsUtils.PropertiesUtil.createMapFromProperties;

public class HeaderConfigs {
    public static Map<String, String> createHeadersFromProperties(String[] headers) throws AutomationException {
        Map<String,String> map = new HashMap<>();
        for (String header: headers
             ) {
            map.putAll(createMapFromProperties(header));
        }
        return map;
    }
}
