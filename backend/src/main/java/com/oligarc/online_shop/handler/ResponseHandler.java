package com.oligarc.online_shop.handler;

import com.oligarc.online_shop.responses.ApiError;
import com.oligarc.online_shop.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data){
        ApiResponse<T> response = new ApiResponse<>(true,message,data);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<ApiError> error(String message, HttpStatus status){
        ApiError error = new ApiError(message,status);
        return new ResponseEntity<>(error,status);
    }
 }
