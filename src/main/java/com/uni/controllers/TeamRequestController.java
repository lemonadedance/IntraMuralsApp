package com.uni.controllers;

import com.uni.daos.TeamDAO;
import com.uni.daos.TeamRequestDAO;
import com.uni.daos.UserDAO;
import com.uni.entities.TeamRequest;
import com.uni.services.RegistrationService;
import com.uni.services.RegistrationServiceImpl;
import io.javalin.http.Context;

public class TeamRequestController {

    private RegistrationService registrationService;

    public TeamRequestController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void createTeamRequest(Context context){
        TeamRequest teamRequest = context.bodyAsClass(TeamRequest.class);
        context.status(201);
        TeamRequest savedRequest = registrationService.createRequest(teamRequest);
        context.json(savedRequest);
    }

    public void getAllTeamRequests(Context context){
        context.json(registrationService.getAllTeamRequests());
    }

    public void approveRequest(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        TeamRequest request = this.registrationService.approveRequest(id);
        context.json(request);
    }

    public void denyRequest(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        TeamRequest request = this.registrationService.denyRequest(id);
        context.json(request);
    }


}
