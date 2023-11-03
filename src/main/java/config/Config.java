package config;

import org.json.JSONObject;
import utilities.jsonUtils.JsonUtils;

/*
 * Class containing all variable used across testing framework
 * */
public class Config {
    //Config variables
    String baseUrlApi;
    String baseUrlUi;
    String browser;

    //Java requires main function to work. Should it be here?
    public static void main(String[] args) {
        Config config = new Config("");
        System.out.println("Configuration values loaded properly:" + config);
    }

    //constructor with parameters to determine what config should be initialized
    Config(String configFileName) {
        //init config_provider class to gather all variables form response
        getVariablesFromFile(configFileName);
    }

    void getVariablesFromFile(String configurationFileName) {
        JsonUtils jsonUtils = new JsonUtils();
        JSONObject configJson = jsonUtils.readJsonFromFileToObject(configurationFileName);
        System.out.println(configJson);
        this.baseUrlApi = jsonUtils.readJsonValue(configJson, "baseUrlApi");
        this.baseUrlUi = jsonUtils.readJsonValue(configJson, "baseUrlUi");
        this.browser = jsonUtils.readJsonValue(configJson, "browser");

    }
}
