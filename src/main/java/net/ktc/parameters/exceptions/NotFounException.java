package net.ktc.parameters.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class NotFounException extends HttpStatusCodeException {
    public NotFounException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
