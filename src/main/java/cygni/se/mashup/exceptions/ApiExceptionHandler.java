package cygni.se.mashup.exceptions;

import org.springframework.http.ResponseEntity;

public class ApiExceptionHandler {
    public ResponseEntity<Object> handleApiRequestException(ApiRequestHandler e) {
        // 1. Create payload containing exception details.
        // 2. Return response entity.

        return null;
    }
}
