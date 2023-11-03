package utilities.jsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
}
