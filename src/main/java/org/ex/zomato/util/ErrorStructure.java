package org.ex.zomato.util;

import org.springframework.http.HttpStatus;

public class ErrorStructure<T> {

    private int statusCode;
    private String message;
    private T rootCause;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRootCause() {
        return rootCause;
    }

    public void setRootCause(T rootCause) {
        this.rootCause = rootCause;
    }

    public static <T> ErrorStructure<T> getErrorStructure(HttpStatus statusCode, T rootCause, String message) {
        ErrorStructure<T> errorStructure = new ErrorStructure<>();
        errorStructure.setStatusCode(statusCode.value());
        errorStructure.setRootCause(rootCause);
        errorStructure.setMessage(message);

        return errorStructure;
    }
}

