package com.oligarc.online_shop.service;

import com.oligarc.online_shop.model.User;

import java.util.Optional;

public interface ServiceUser {

    Optional<User> findByEmail(String email);
}
