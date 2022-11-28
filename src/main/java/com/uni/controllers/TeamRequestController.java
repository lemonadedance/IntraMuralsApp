package com.uni.controllers;

import com.uni.entities.TeamRequest;
import com.uni.services.RegistrationService;
import io.javalin.http.Context;

import java.util.NoSuchElementException;

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
        String team = context.queryParam("team");
        String userId = context.queryParam("userId");

        if(team == null && userId == null){
            context.json(registrationService.getAllTeamRequests());
        } else if (team != null){
            context.json(registrationService.filterTeamRequestsByTeam(team));
        } else if (userId != null) {
            try {
                context.json(registrationService.filterTeamRequestsByPlayer(Integer.parseInt(userId)));
            } catch (NoSuchElementException e) {
                context.status(404);
            }
        }

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
