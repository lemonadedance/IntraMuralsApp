package com.uni.app;

import com.uni.controllers.SchedulingController;
import com.uni.controllers.TeamController;
import com.uni.controllers.UserController;
import com.uni.daos.*;
import com.uni.datautils.ConnectionUtil;
import com.uni.services.RegistrationService;
import com.uni.services.RegistrationServiceImpl;
import com.uni.services.SchedulingService;
import com.uni.services.SchedulingServiceImpl;
import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.jackson.JacksonModelConverterFactory;
import io.javalin.plugin.openapi.jackson.JacksonToJsonMapper;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class App {

    public static void main(String[] args) throws IOException {
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        });


        //DAOs
        GameDAO gameDAO = GameDAO.getSingleton();
        SeasonDAO seasonDAO = SeasonDAO.getSingleton();
        TeamDAO teamDAO = TeamDAO.getSingleton();
        TeamRequestDAO teamRequestDAO = TeamRequestDAO.getSingleton();
        UserDAO userDAO = UserDAO.getSingleton();
        VenueDAO venueDAO = VenueDAO.getSingleton();

        //Services
        RegistrationService registrationService = new RegistrationServiceImpl(teamDAO,userDAO,teamRequestDAO);
        SchedulingService schedulingService = new SchedulingServiceImpl(venueDAO,gameDAO,seasonDAO);


        //Controllers
        SchedulingController schedulingController = new SchedulingController(schedulingService);
        TeamController teamController = new TeamController(registrationService);
        UserController userController = new UserController(registrationService);


        app.post("/login", userController::login);

        app.post("/teams", teamController::registerTeam);
        app.get("/teams",teamController::retrieveAllTeams);

        app.get("/venues", schedulingController::getAllVenues);

        app.post("/games",schedulingController::scheduleGame);
        app.get("/games",schedulingController::getAllGames);

        app.get("/seasons",schedulingController::getAllSeasons);


        app.start();

    }
}
