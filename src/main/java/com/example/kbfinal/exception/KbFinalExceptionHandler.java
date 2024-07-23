package com.example.kbfinal.exception;

import com.example.kbfinal.dto.KbFinalErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.kbfinal.exception.KbFinalErrorCode.INTERNAL_SERVER_ERROR;
import static com.example.kbfinal.exception.KbFinalErrorCode.INVALID_REQUEST;

@Slf4j
@RestControllerAdvice
public class KbFinalExceptionHandler {
    @ExceptionHandler(KbFinalException.class)
    public KbFinalErrorResponse handlerException(
            KbFinalException e,
            HttpServletRequest request){
        log.error("errorCode : {}, url : {}, message : {}",
                e.getKbFinalErrorCode(), request.getRequestURI(), e.getDetailMessage());
        return KbFinalErrorResponse.builder()
                .errorCode(e.getKbFinalErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }

    @ExceptionHandler(value={
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
    })

    public KbFinalErrorResponse handleBadRequest(
            Exception e, HttpServletRequest request
    ){
        log.error("url : {}, message : {}",
                request.getRequestURI(), e.getMessage());
        return KbFinalErrorResponse.builder()
                .errorCode(INVALID_REQUEST)
                .errorMessage(INVALID_REQUEST.getMessage())
                .build();

    }

    @ExceptionHandler(Exception.class)
    public KbFinalErrorResponse handleException(
            Exception e, HttpServletRequest request
    ){
        log.error("url : {}, message : {}",
                request.getRequestURI(), e.getMessage());
        return KbFinalErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR)
                .errorMessage(INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}
