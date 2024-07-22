package com.example.kbfinal.config;

import com.example.kbfinal.common.exception.CustomException;
import com.example.kbfinal.common.exception.response.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponseError> handleUserException(CustomException exception){
        ApiResponseError response = ApiResponseError.of(exception);
        HttpStatus httpStatus = exception
                .getErrorCode()
                .defaultHttpStatus();
        return new ResponseEntity<>(response, httpStatus);
    }
}
