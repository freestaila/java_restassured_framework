package config.github.api;

import org.json.JSONObject;
import org.testng.annotations.*;
import utilities.jsonUtils.JsonUtils;

import static utilities.requestsUtils.PropertiesUtil.loadProperties;

public class Config {
    @BeforeSuite
    @Parameters("config-File-Path")
    public void setup(String configFilePath) {
        System.setProperty("base_url",loadProperties(configFilePath).getProperty("baseURL"));
    }
}
