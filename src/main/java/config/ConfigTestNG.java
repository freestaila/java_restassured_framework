package config;

import io.restassured.RestAssured;
import org.checkerframework.checker.signature.qual.BinaryNameOrPrimitiveType;
import org.json.JSONObject;
import org.testng.annotations.*;
import utilities.jsonUtils.JsonUtils;

public class ConfigTestNG {
    @BeforeSuite
    @Parameters("config-File-Path")
    public void setup(String configFilePath) {
        JSONObject configData = JsonUtils.readJsonFromFileToObject(configFilePath);
        System.setProperty("base_url",JsonUtils.readJsonValue(configData, "baseURL") );
    }
}
