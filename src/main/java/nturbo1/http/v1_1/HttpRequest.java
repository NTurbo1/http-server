package nturbo1.http.v1_1;

import nturbo1.http.HttpMethod;

import java.util.Map;

public class HttpRequest extends HttpMessage
{
    private String URI; // TODO: Create a URI class and implement a parser for that!!!

    public HttpRequest() {}

    public HttpRequest(HttpMethod method, Map<String, String> headers, Object body, String URI)
    {
        super(method, headers, body);
        this.URI = URI;
    }

    public void setURI(String URI) { this.URI = URI; }
}