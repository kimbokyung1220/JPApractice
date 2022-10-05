package com.sparta.post.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//        log.error("handleException", ex);
//        ErrorResponse response = new ErrorResponse(ErrorCode.NOT_FOUND);
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
}