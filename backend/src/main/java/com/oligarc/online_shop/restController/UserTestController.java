package com.oligarc.online_shop.restController;

import com.oligarc.online_shop.config.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserTestController {

    private final CustomUserDetailsService userDetailsService;

    public UserTestController(CustomUserDetailsService userDetailsService){
        this.userDetailsService=userDetailsService;
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<?> getUser(@PathVariable String email){
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            return ResponseEntity.ok(userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
