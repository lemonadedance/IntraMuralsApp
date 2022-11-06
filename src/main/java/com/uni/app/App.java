package com.uni.app;

import com.uni.controllers.SchedulingController;
import com.uni.controllers.TeamController;
import com.uni.controllers.UserController;
import io.javalin.Javalin;


public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());


        app.post("/login", UserController::login);

        app.post("/teams", TeamController::registerTeam);
        app.get("/teams",TeamController::retrieveAllTeams);

        app.get("/venues", SchedulingController::getAllVenues);

        app.post("/games",SchedulingController::scheduleGame);
        app.get("/games",SchedulingController::getAllGames);

        app.get("/seasons",SchedulingController::getAllSeasons);


        app.start();

    }
}
