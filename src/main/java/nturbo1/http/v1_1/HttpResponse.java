package nturbo1.http.v1_1;

import nturbo1.http.HttpMethod;
import nturbo1.http.HttpStatus;

import java.util.Map;

public class HttpResponse extends HttpMessage
{
    private final HttpStatus status;

    public HttpResponse(HttpStatus status, HttpMethod method, Map<String, String> headers, Object body)
    {
        super(method, headers, body);
        this.status = status;
    }
}