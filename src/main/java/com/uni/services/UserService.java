package com.uni.services;

import com.uni.models.ImUser;
import com.uni.models.LoginCredentials;

public interface UserService {


    ImUser getUserFromLoginCredentials(LoginCredentials loginCredentials);
    ImUser updateImUser(ImUser imUser);
    ImUser createUser(ImUser imUser);
}
