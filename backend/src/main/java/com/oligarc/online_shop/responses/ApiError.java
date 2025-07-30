package com.oligarc.online_shop.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ApiError {
    private boolean success = false;
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiError(String message,HttpStatus status){
        this.message = message;
        this.status=status;
    }
}
