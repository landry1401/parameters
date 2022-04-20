package net.ktc.parameters.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ConfliException extends HttpStatusCodeException {
    public ConfliException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
