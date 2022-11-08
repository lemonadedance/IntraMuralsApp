package com.uni.app;

import com.uni.controllers.SchedulingController;
import com.uni.controllers.TeamController;
import com.uni.controllers.UserController;
import com.uni.datautils.ConnectionUtil;
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

            Info applicationInfo = new Info().version("1.0").description("IntraMural application");
            OpenApiOptions options = new OpenApiOptions(applicationInfo);
            options.path("/swagger-docs");
            options.activateAnnotationScanningFor("com.uni.controllers");
            options.swagger(new SwaggerOptions("/swagger").title("IntraMural Swagger Documentation"));

            config.registerPlugin(new OpenApiPlugin(options));
        });


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
