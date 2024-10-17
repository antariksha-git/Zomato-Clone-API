package org.ex.zomato.exceptionhandler;

import lombok.Getter;
import lombok.Setter;
import org.ex.zomato.util.ErrorStructure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorBody> errors = ex.getAllErrors().stream().map(error -> (FieldError) error)
                .map(error -> new ErrorBody(error.getField(), error.getRejectedValue(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorStructure.getErrorStructure(HttpStatus.BAD_REQUEST, errors, "Invalid Input"));
    }

    @Getter
    @Setter
    static class ErrorBody {
        private String fieldName;
        Object rejectedValue;
        String message;

        public ErrorBody(String fieldName, Object rejectedValue, String message) {
            this.fieldName = fieldName;
            this.rejectedValue = rejectedValue;
            this.message = message;
        }
    }
}
