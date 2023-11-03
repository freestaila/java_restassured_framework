package utilities.requestsUtils;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
    public Map<String, String> defaultHeaders() {
        Map<String, String> defaultHeaders = new HashMap<String, String>();
        defaultHeaders.put("Accept", "application/vnd.github+json");
        defaultHeaders.put("Authorization", "Bearer <YOUR-TOKEN>");
        defaultHeaders.put("X-GitHub-Api-Version", "2022-11-28");
        return defaultHeaders;
    }
}
