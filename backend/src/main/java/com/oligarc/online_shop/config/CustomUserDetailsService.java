package com.oligarc.online_shop.config;

import com.oligarc.online_shop.model.User;
import com.oligarc.online_shop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    //UserDetailsService is a Spring Security interface that defines how to load an user from the db

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository v_userRepository){
        this.userRepository=v_userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " +email));
        return org.springframework.security.core.userdetails.User.
                withUsername(user.getEmail())
                .password("{noop}" + user.getPassword())
                .roles("USER")
                .build();
    }
}
