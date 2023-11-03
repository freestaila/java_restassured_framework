package applications.github.api.user;

import applications.github.api.user_module.models.User;
import applications.github.api.user_module.services.UserService;
import config.ConfigTestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.requestsUtils.AutomationException;
import utilities.requestsUtils.HttpStatus;

import static applications.github.api.user_module.builders.UserBuilder.createRandomUser;
import static applications.github.api.user_module.builders.UserBuilder.createUserBodyFromJson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class TC_GetUserInfo extends ConfigTestNG {
    // Positive scenario
    @Test
    @Parameters("expectedUserData")
    public void getExistingUserInfoStatus(String expectedUserData) throws AutomationException {
        User expectedUser = createUserBodyFromJson(expectedUserData);
        User actualUser = (User) UserService.init().getUserInfo(expectedUser).getResponse();
        assertThat(actualUser, samePropertyValuesAs(expectedUser));
    }

    @Test
    public void getNoExistingUserInfoStatus() throws AutomationException {
        User expectedUser = createRandomUser(8);
        UserService.init().isNegativeTest(HttpStatus.NOT_FOUND).getUserInfo(expectedUser).getResponse();
    }
}
