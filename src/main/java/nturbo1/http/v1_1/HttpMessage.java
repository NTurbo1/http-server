package nturbo1.http.v1_1;

import nturbo1.http.HttpMethod;
import nturbo1.http.HttpStatus;

import java.util.Map;

/**
 * Represents a generic HTTP message.
 *
 * generic-message = start-line
 *                   *(message-header CRLF)
 *                   CRLF
 *                   [ message-body ]
 * start-line      = Request-Line | Status-Line
 *
 */
public abstract class HttpMessage
{
    private HttpStatus status;
    private HttpMethod method;
    private Map<String, String> headers;
    private Object body;

    public HttpMessage() {}

    public HttpMessage(HttpStatus status, HttpMethod method, Map<String, String> headers, Object body)
    {
        this.status = status;
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    // GETTERS
    public HttpStatus getStatus() { return this.status; }
    public Map<String, String> getHeaders() { return this.headers; }
    public Object getBody() { return this.body; }

    // SETTERS
    public void setStatus(HttpStatus status) { this.status = status; }
    public void setMethod(HttpMethod method) { this.method = method; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }
    public void setBody(Object body) { this.body = body; }
}