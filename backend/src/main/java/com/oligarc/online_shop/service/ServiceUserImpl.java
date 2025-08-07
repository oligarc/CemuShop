package com.oligarc.online_shop.service;

import com.oligarc.online_shop.model.User;
import com.oligarc.online_shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceUserImpl implements ServiceUser{

    private UserRepository userRepository;

    public ServiceUserImpl(UserRepository v_userRepository){
        this.userRepository=v_userRepository;
    }


    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
