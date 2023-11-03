package applications.github.api.user_module.services;

import applications.github.api.user_module.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import utilities.requestsUtils.AutomationException;
import utilities.requestsUtils.HttpStatus;
import utilities.requestsUtils.RequestsUtil;
import utilities.requestsUtils.builders.RequestBuilder;
import io.restassured.http.ContentType;


import java.util.List;
import java.util.Map;

import static applications.github.api.user_module.constants.UsersEndPoint.GET_USER_INFO;

public class UserService {
    private RequestBuilder requestBuilder;
    private User expectedUser;
    private Object responsePayload;
    private boolean isNegativeTest = false;
    private HttpStatus httpStatus = HttpStatus.OK;
    private Map<String, String> headers;
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
                        .path(GET_USER_INFO + expectedUser.getLogin())
                        .expectedStatusCode(httpStatus)
                        .expectedResponseContentType(reponseContentType)
                        .get();

        if(!isNegativeTest) {
            responsePayload = restInstance.responseToPojo(User.class);
        }
        return this;
    }

    public Object getResponse() {
        return responsePayload;
    }
}
