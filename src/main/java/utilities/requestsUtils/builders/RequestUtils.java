package utilities.requestsUtils.builders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static utilities.jsonUtils.JsonUtils.readJsonFromFileToString;

public class RequestUtils {

    public static RequestBuilder createRequestObject(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(readJsonFromFileToString(filePath), RequestBuilder.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
