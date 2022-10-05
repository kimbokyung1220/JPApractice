package com.sparta.post.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj, String error) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sucsess", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        map.put("error", error);

        return new ResponseEntity<Object>(map,status);
    }
}
