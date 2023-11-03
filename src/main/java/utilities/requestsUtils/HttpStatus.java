package utilities.requestsUtils;

public enum HttpStatus {

    //The request was successful and the response body contains the representation requested.
    OK(200, "OK"),
    //The request was successful, we updated the resource and the response body contains the representation.
    OK_UPDATE(201, "OK"),
    //POST, PUT, DELETE
    //The request has been accepted for further processing, which will be completed sometime later.
    ACCEPTED(202, "ACCEPTED"),
    //The request was successful; the resource was deleted.
    OK_DELETE(204, "OK"),
    /*
     * HTTP GET
     */
    //A common redirect response; you can GET the representation at the URI in the Location response header.
    FOUND(302, "FOUND"),
    //There is no new data to return.
    NOT_MODIFIED(304, "NOT MODIFIED"),
    // The request was invalid or cannot be otherwise served. An accompanying error message will explain further. For security reasons, requests without authentication are considered invalid and will yield this response.
    BAD_REQUEST(400, "BAD REQUEST"),
    //The authentication credentials are missing, or if supplied are not valid or not sufficient to access the resource.
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    //The request has been refused. See the accompanying message for the specific reason (most likely for exceeding rate limit).
    FORBIDDEN(403, "FORBIDDEN"),
    // The URI requested is invalid or the resource requested does not exists.
    NOT_FOUND(404, "NOT FOUND"),
    //The request specified an invalid format.
    NOT_ACCEPTABLE(406, "NOT ACCEPTABLE"),
    //This resource is gone. Used to indicate that an API endpoint has been turned off.
    GONE(410, "GONE"),
    //Returned when a request cannot be served due to the application’s rate limit having been exhausted for the resource.
    TOO_MANY_REQUESTS(429, "TOO MANY REQUESTS"),
    //Something is horribly wrong.
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR"),
    //The service is down or being upgraded. Try again later.
    BAD_GATEWAY(502, "BAD GATEWAY"),
    //The service is up, but overloaded with requests. Try again later.
    SERVICE_UNAVAILABLE0(503, "SERVICE UNAVAILABLE0"),
    //Servers are up, but the request couldn’t be serviced due to some failure within our stack. Try again later.
    GATEWAY_TIMEOUT(504, "GATEWAY TIMEOUT");

    private int code;
    private String message;
    private String text;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
        this.text = Integer.toString(code);
    }

    /**
     * Gets the HTTP status code
     *
     * @return the status code number
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the HTTP status code as a text string
     *
     * @return the status code as a text string
     */
    public String asText() {
        return text;
    }

    /**
     * Get the description
     *
     * @return the description of the status code
     */
    public String getMessage() {
        return message;
    }
}