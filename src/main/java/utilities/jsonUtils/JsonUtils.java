package utilities.jsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import utilities.requestsUtils.AutomationException;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonUtils {

    public static String readJsonFromFileToString(String file) {
        File readFile = new File(file);
        try {
            return new String(Files.readAllBytes(Paths.get(readFile.toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Parse json object from file
    public static JSONObject readJsonFromFileToObject(String file) {
        return new JSONObject(readJsonFromFileToString(file));
    }

    public static String readJsonValue(JSONObject jsonObject, String keyName) throws JSONException {
        return jsonObject.getString(keyName);
    }

    //Read provided json file to class type object
    public static <T> T jsonToObject(String jsonPath, Class<T> type) throws AutomationException {
        try {
            return new ObjectMapper().readValue(readJsonFromFileToString(jsonPath), type);
        } catch (IOException ioex) {
            throw new AutomationException("Provided data not match to expected Object type: " + type.getName() + ioex);
        }
    }
}
