package applications.github.api.user_module.builders;

import applications.github.api.user_module.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static utilities.common.RandomStringGenerator.randomString;
import static utilities.jsonUtils.JsonUtils.readJsonFromFileToString;

public class UserBuilder {
    public static User createRandomUser(int length) {
        return User.builder().login(randomString(length)).build();
    }

    public static User createUserBodyFromJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(readJsonFromFileToString(filePath), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
