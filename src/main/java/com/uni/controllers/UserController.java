package com.uni.controllers;

import com.uni.daos.UserDAO;
import com.uni.models.ImUser;
import com.uni.models.LoginCredentials;
import com.uni.services.UserService;
import com.uni.services.UserServiceImpl;
import io.javalin.http.Context;

public class UserController {

    private static UserService userService = new UserServiceImpl(new UserDAO());

    public static void login(Context ctx){
        LoginCredentials credentials = ctx.bodyAsClass(LoginCredentials.class);
        ImUser user = userService.getUserFromLoginCredentials(credentials);
        ctx.sessionAttribute("user",user);
        ctx.json(user);
    };



}
