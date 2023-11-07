package applications.github.api.user;

import applications.github.api.user_module.models.User;
import applications.github.api.user_module.services.UserService;
import config.github.api.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.jsonUtils.JsonUtils;
import utilities.requestsUtils.AutomationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static utilities.requestsUtils.HeaderConfigs.createHeadersFromProperties;

public class TC_PatchUserInfo extends Config {
    public static final Logger _logger = LogManager.getLogger(Config.class);

    // Positive scenario
    @Test
    @Parameters({"updatedUserData","headersPath","userTokenPath"})
    public void assertThatAuthenticatedUserBioIsUpdated(String updatedUserDataJsonPath, String headersPath, String userTokenPath) throws AutomationException {
        _logger.info("Perform test that check if after PATCH request data is changed");
        User newUserData = JsonUtils.jsonToObject(updatedUserDataJsonPath, User.class);
        User patchUser = (User) UserService.init().
                patchUser(updatedUserDataJsonPath, createHeadersFromProperties(new String[] {headersPath,userTokenPath})).
                getResponse();
        _logger.info("NEW USER BIO:" + newUserData.getBio());
        _logger.info("USER BIO AFTER PATCH:" + patchUser.getBio());
        assertThat(newUserData.getBio() ,samePropertyValuesAs(patchUser.getBio()));

    }
}
