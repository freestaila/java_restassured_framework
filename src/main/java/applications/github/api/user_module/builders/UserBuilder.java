package applications.github.api.user_module.builders;

import applications.github.api.user_module.models.User;
import utilities.jsonUtils.JsonUtils;
import utilities.requestsUtils.AutomationException;

import static utilities.common.RandomStringGenerator.randomString;

public class UserBuilder {
    public static User createRandomUser(int length) {
        return User.builder().login(randomString(length)).build();
    }

    public static User createUserBodyFromJson(String filePath) throws AutomationException {
        return JsonUtils.jsonToObject(filePath, User.class);
    }
}
