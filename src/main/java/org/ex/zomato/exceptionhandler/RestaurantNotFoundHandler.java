package org.ex.zomato.exceptionhandler;

import org.ex.zomato.exception.RestaurantNotFoundByIdException;
import org.ex.zomato.util.AppResponseBuilder;
import org.ex.zomato.util.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantNotFoundHandler {

    @ExceptionHandler(RestaurantNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleRestaurantNotFoundByIdException(RestaurantNotFoundByIdException e) {
        return AppResponseBuilder.error(HttpStatus.NOT_FOUND, e.getMessage(), "Given restaurant id doesn't exist");
    }
}
