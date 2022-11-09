package com.uni.controllers;

import com.uni.daos.UserDAO;
import com.uni.models.ImUser;
import com.uni.models.LoginCredentials;
import com.uni.services.UserService;
import com.uni.services.UserServiceImpl;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.*;

public class UserController {

    private static UserService userService = new UserServiceImpl(UserDAO.getSingleton());

    @OpenApi(
            path = "/login",
            method = HttpMethod.POST,
            description = "Functionality for logging in. If a valid username and password are provided, then an HttpSession attribute 'user' is created that contains a valid corresponding ImUser object",
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = LoginCredentials.class)),
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = ImUser.class))
            }
    )
    public static void login(Context ctx){
        LoginCredentials credentials = ctx.bodyAsClass(LoginCredentials.class);
        ImUser user = userService.getUserFromLoginCredentials(credentials);
        ctx.sessionAttribute("user",user);
        ctx.json(user);
    };



}
