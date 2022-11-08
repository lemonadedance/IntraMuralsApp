package com.uni.services;

import com.uni.daos.UserDAO;
import com.uni.exceptions.PasswordMismatchException;
import com.uni.models.ImUser;
import com.uni.models.LoginCredentials;

public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserServiceImpl(UserDAO userDao){
        this.userDao = userDao;
    };


    @Override
    public ImUser getUserFromLoginCredentials(LoginCredentials loginCredentials) {

        ImUser imUser = this.userDao.getByUsername(loginCredentials.getUsername());

        if(!imUser.getPassword().equals(loginCredentials.getPassword())){
            throw new PasswordMismatchException();
        }
        return imUser;

    }

    @Override
    public ImUser updateImUser(ImUser imUser) {
        return null;
    }

    @Override
    public ImUser createUser(ImUser imUser) {
        return null;
    }
}
