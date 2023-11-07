package utilities.requestsUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestsUtil {

    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification requestSpecification;
    private Response apiResponse;

    private HttpStatus expectedStatusCode = HttpStatus.OK;
    private String expectedResponseContentType;

    /**
     * Returns a new object of RequestsUtil class
     *
     * @return this
     * @throws AutomationException
     */
    public static RequestsUtil init() throws AutomationException {
        return new RequestsUtil();
    }

    /**
     * RequestsUtil Default Constructor
     *
     * @throws AutomationException
     */
    public RequestsUtil() throws AutomationException {
        initializeRequestSpec();
    }

    /**
     * Initializes Request Specifications including the Base URI Path from test.properties
     *
     * @throws AutomationException
     */
    private void initializeRequestSpec() throws AutomationException {

        requestSpecBuilder = new RequestSpecBuilder();
        EncoderConfig encoderconfig = new EncoderConfig();
        /* ----- H E A D E R S ----- */
        requestSpecBuilder.setBaseUri(System.getProperty("base_url"));
        requestSpecBuilder.setConfig(RestAssured.config().encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)));
    }

    /**
     * Defines API Endpoint Path to Request Specification
     *
     * @param path
     * @return this
     */
    public RequestsUtil path(String path) {
        requestSpecBuilder.setBasePath(path);
        return this;
    }

    /**
     * Defines Path Parameters to Request Specification
     *
     * @param key
     * @param value
     * @return this
     */
    public RequestsUtil pathParam(String key, String value) {
        requestSpecBuilder.addPathParam(key, value);
        return this;
    }

    /**
     * Defines Query Parameters to Request Specification
     *
     * @param key
     * @param value
     * @return this
     */
    public RequestsUtil queryParam(String key, String value) {
        requestSpecBuilder.addQueryParam(key, value);
        return this;
    }

    /**
     * Defines Content Type Header to Request Specification
     *
     * @param contentType
     * @return this
     */
    public RequestsUtil contentType(ContentType contentType) {
        requestSpecBuilder.setContentType(contentType);
        return this;
    }

    /**
     * Defines Headers to Request Specification
     *
     * @param headers
     * @return this
     */
    public RequestsUtil headers(Map<String, String> headers) {
        requestSpecBuilder.addHeaders(headers);
        return this;
    }

    /**
     * Defines Cookies to Request Specification
     *
     * @param cookies
     * @return this
     */
    public RequestsUtil cookies(Map<String, String> cookies) {
        requestSpecBuilder.addCookies(cookies);
        return this;
    }

    /**
     * Defines Cookies to Request Specification
     *
     * @param cookies
     * @return this
     */
    public RequestsUtil cookies(Cookies cookies) {
        requestSpecBuilder.addCookies(cookies);
        return this;
    }

    /**
     * Defines Cookie to Request Specification
     *
     * @param cookie
     * @return this
     */
    public RequestsUtil cookie(Cookie cookie) {
        requestSpecBuilder.addCookie(cookie);
        return this;
    }

    /**
     * Defines Body to Request Specification
     *
     * @param body
     * @return this
     */
    public RequestsUtil body(Object body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    /**
     * Defines the Expected Status Code following successful api execution for validation
     *
     * @param expectedStatusCode
     * @return this
     */
    public RequestsUtil expectedStatusCode(HttpStatus expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
        return this;
    }

    /**
     * Defines the Expected Response Content Type following successful api execution for validation
     *
     * @param contentType
     * @return this
     */
    public RequestsUtil expectedResponseContentType(ContentType contentType) {
        this.expectedResponseContentType = contentType.toString();
        return this;
    }

    /**
     * Defines the Expected Response Content Type following successful api execution for validation
     *
     * @param contentType
     * @return this
     */
    public RequestsUtil expectedResponseContentType(String contentType) {
        this.expectedResponseContentType = contentType;
        return this;
    }

    /**
     * Hits the Pre-Defined Request Specification as PATCH Request
     * <p>
     * On successful response, method validates:
     * -   Status Code against the Status Code provided in Request Specification
     * -   Content Type against the Content Type provided in Request Specification
     *
     * @return this
     */
    public RequestsUtil patch() {
        requestSpecification = requestSpecBuilder.build();
        apiResponse =
                given()
                        .log().all()
                        .spec(requestSpecification)
                        .when()
                        .patch()
                        .then()
                        .assertThat()
                        .statusCode(expectedStatusCode.getCode())
                        .contentType(expectedResponseContentType)
                        .and()
                        .extract()
                        .response();

        return this;
    }

    /**
     * Hits the Pre-Defined Request Specification as PUT Request
     * <p>
     * On successful response, method validates:
     * -   Status Code against the Status Code provided in Request Specification
     * -   Content Type against the Content Type provided in Request Specification
     *
     * @return this
     */
    public RequestsUtil put() {
        requestSpecification = requestSpecBuilder.build();
        apiResponse =
                given()
                        .log().all()
                        .spec(requestSpecification)
                        .when()
                        .put()
                        .then()
                        .assertThat()
                        .statusCode(expectedStatusCode.getCode())
                        .contentType(expectedResponseContentType)
                        .and()
                        .extract()
                        .response();

        return this;
    }

    /**
     * Hits the Pre-Defined Request Specification as DELETE Request
     * <p>
     * On successful response, method validates:
     * -   Status Code against the Status Code provided in Request Specification
     * -   Content Type against the Content Type provided in Request Specification
     *
     * @return this
     */
    public RequestsUtil delete() {
        requestSpecification = requestSpecBuilder.build();
        apiResponse =
                given()
                        .log().all()
                        .spec(requestSpecification)
                        .when()
                        .delete()
                        .then()
                        .assertThat()
                        .statusCode(expectedStatusCode.getCode())
                        .contentType(expectedResponseContentType)
                        .and()
                        .extract()
                        .response();

        return this;
    }

    /**
     * Hits the Pre-Defined Request Specification as POST Request
     * <p>
     * On successful response, method validates:
     * -   Status Code against the Status Code provided in Request Specification
     * -   Content Type against the Content Type provided in Request Specification
     *
     * @return this
     */
    public RequestsUtil post() {
        requestSpecification = requestSpecBuilder.build();
        apiResponse =
                given()
                        .log().all()
                        .spec(requestSpecification)
                        .when()
                        .post()
                        .then()
                        .assertThat()
                        .statusCode(expectedStatusCode.getCode())
                        .contentType(expectedResponseContentType)
                        .and()
                        .extract()
                        .response();

        return this;
    }

    /**
     * Hits the Pre-Defined Request Specification as GET Request
     * <p>
     * On successful response, method validates:
     * -   Status Code against the Status Code provided in Request Specification
     * -   Content Type against the Content Type provided in Request Specification
     *
     * @return this
     */
    public RequestsUtil get() {
        requestSpecification = requestSpecBuilder.build();
        apiResponse =
                given()
                        .log().all()
                        .spec(requestSpecification)
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(expectedStatusCode.getCode())
                        .contentType(expectedResponseContentType)
                        .and()
                        .extract()
                        .response();

        return this;
    }

    /**
     * Returns the apiResponse Object
     *
     * @return apiResponse
     */
    public Response response() {
        return apiResponse;
    }

    /**
     * Returns the apiResponse Object as String
     *
     * @return apiResponse
     */
    public String getApiResponseAsString() {
        return apiResponse.asString();
    }

    /**
     * Converts the Response Object into the provided Class Type
     *
     * @param type
     * @param <T>
     * @return
     * @throws AutomationException
     */
    public <T> T responseToPojo(Class<T> type) throws AutomationException {
        try {
            return new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY).readValue(getApiResponseAsString(), type);
        } catch (IOException ioex) {
            throw new AutomationException("Response Received did not match the expected Response Format POJO: " + type.getName() + ioex);
        }
    }

    /**
     * Converts the Response Object into the provided Class Type
     *
     * @param type
     * @param <T>
     * @return
     * @throws AutomationException
     */
    public <T> T responseToPojo(TypeReference type) throws AutomationException {
        try {
            return (T) new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY).readValue(getApiResponseAsString(), type);
        } catch (IOException ioex) {
            throw new AutomationException(ioex);
        }
    }
}
