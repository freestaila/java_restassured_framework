package applications.github.api.user;

import applications.github.api.user_module.models.User;
import applications.github.api.user_module.services.UserService;
import config.github.api.Config;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.jsonUtils.JsonUtils;
import utilities.requestsUtils.AutomationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static utilities.requestsUtils.HeaderConfigs.createHeadersFromProperties;

public class TC_PatchUserInfo extends Config {
    // Positive scenario
    @Test
    @Parameters({"updatedUserData","headersPath","userTokenPath"})
    public void assertThatAuthenticatedUserBioIsUpdated(String updatedUserDataJsonPath, String headersPath, String userTokenPath) throws AutomationException {
        User newUserData = JsonUtils.jsonToObject(updatedUserDataJsonPath, User.class);
        User patchUser = (User) UserService.init().
                patchUser(updatedUserDataJsonPath, createHeadersFromProperties(new String[] {headersPath,userTokenPath})).
                getResponse();
        assertThat(newUserData.getBio() ,samePropertyValuesAs(patchUser.getBio()));
    }
}
