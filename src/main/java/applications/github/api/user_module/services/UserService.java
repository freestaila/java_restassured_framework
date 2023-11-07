package applications.github.api.user_module.services;

import applications.github.api.user_module.models.User;
import utilities.jsonUtils.JsonUtils;
import utilities.requestsUtils.AutomationException;
import utilities.requestsUtils.HeaderConfigs;
import utilities.requestsUtils.HttpStatus;
import utilities.requestsUtils.RequestsUtil;
import io.restassured.http.ContentType;

import java.util.Map;

import static applications.github.api.user_module.constants.UsersEndpoints.USERS_ENDPOINT;
import static applications.github.api.user_module.constants.UsersEndpoints.USER_ENDPOINT;
import static utilities.jsonUtils.JsonUtils.readJsonFromFileToString;

public class UserService {
    private Object responsePayload;
    private boolean isNegativeTest = false;
    private HttpStatus httpStatus = HttpStatus.OK;
    private ContentType reponseContentType = ContentType.JSON;

    public static UserService init() {
        return new UserService();
    }

    public UserService isNegativeTest(HttpStatus httpStatus) {
        this.isNegativeTest = true;
        this.httpStatus = httpStatus;
        return this;
    }

    public UserService getUserInfo(User expectedUser) throws AutomationException {
      RequestsUtil restInstance =
                RequestsUtil.init()
                        .path(USERS_ENDPOINT + expectedUser.getLogin())
                        .expectedStatusCode(httpStatus)
                        .expectedResponseContentType(reponseContentType)
                        .get();

        if(!isNegativeTest) {
            responsePayload = restInstance.responseToPojo(User.class);
        }
        return this;
    }

    /**
    * Send PATCH User request
    * @param userDataToUpdate - convert data from JSON to String, avoid sending null fields except you would like to set them as null
     * Parameters that could be in param: "name", "email", "blog", "twitter_username", "company", "location", "hireable", "bio"
     * Please use update_user_data_schema.json as template
    */
    public UserService patchUser(String userDataToUpdate, Map<String, String> headersWithBearerToken) throws AutomationException{
        RequestsUtil restInstance =
                RequestsUtil.init().headers(headersWithBearerToken).
                        path(USER_ENDPOINT).
                        contentType(ContentType.JSON).
                        body(readJsonFromFileToString(userDataToUpdate)).
                        expectedStatusCode(httpStatus.OK).
                        expectedResponseContentType(reponseContentType).patch();

        if(!isNegativeTest) {
            responsePayload = restInstance.responseToPojo(User.class);
        }
        return this;
    }
    public Object getResponse() {
        return responsePayload;
    }
}
