package cygni.se.mashup.exceptions;

public class ErrorTypes extends RuntimeException {

    public ErrorTypes(String message) {
        super(message);
    }

    public ErrorTypes(String message, Throwable cause) {
        super(message, cause);
    }
}
