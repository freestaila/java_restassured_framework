package utilities.requestsUtils.builders;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
public class RequestBuilder {
    @NonNull
    String baseURL;
    @NonNull
    String path;
    Map<String, String> headers;
    Map<String, String> body;
}


