package com.uni.controllers;

import com.uni.daos.TeamDAO;
import com.uni.models.Team;
import com.uni.services.TeamService;
import com.uni.services.TeamServiceImpl;
import io.javalin.http.Context;

public class TeamController {

    private static TeamService teamService = new TeamServiceImpl(new TeamDAO());

    public static void registerTeam(Context context){
        Team team = context.bodyAsClass(Team.class);
        teamService.registerTeam(team);
        context.status(204);
    }

    public static void retrieveAllTeams(Context context){
        context.json(teamService.getAllTeams());
    }
}
