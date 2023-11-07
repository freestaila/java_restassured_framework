package config.github.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.jsonUtils.JsonUtils;

import static utilities.requestsUtils.PropertiesUtil.loadProperties;

public class Config {
    private static final Logger _logger = LogManager.getLogger(Config.class);

    @BeforeSuite
    @Parameters("config-File-Path")
    public void setup(String configFilePath, ITestContext context) {
        System.setProperty("base_url", loadProperties(configFilePath).getProperty("baseURL"));
        _logger.info("Server baseURL: " + System.getProperty("base_url"));
    }
}
