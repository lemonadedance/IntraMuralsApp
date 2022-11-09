package com.uni.controllers;

import com.uni.daos.GameDAO;
import com.uni.daos.SeasonDAO;
import com.uni.daos.VenueDAO;
import com.uni.entities.Game;
import com.uni.entities.Season;
import com.uni.entities.Venue;
import com.uni.services.SchedulingService;
import com.uni.services.SchedulingServiceImpl;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.*;

public class SchedulingController {


    private static SchedulingService schedulingService = new SchedulingServiceImpl(VenueDAO.getSingleton(), GameDAO.getSingleton(), SeasonDAO.getSingleton());

    @OpenApi(
            path = "/venues",
            method = HttpMethod.GET,
            description = "Functionality for retrieving an array of all venues",
            responses = {
                  @OpenApiResponse(status = "200", content = @OpenApiContent(from = Venue.class, isArray = true))
            }
    )
    public static void getAllVenues(Context context){
        context.json(schedulingService.getAllVenues());
    }

    @OpenApi(
            path = "/games",
            method = HttpMethod.POST,
            description = "Functionality for scheduling a game",
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = Game.class)),
            responses = {
                @OpenApiResponse(status = "201", content = @OpenApiContent(from = Game.class))
            }
    )
    public static void scheduleGame(Context context){
        Game incomingGame = context.bodyAsClass(Game.class);
        Game scheduledGame = schedulingService.scheduleGame(incomingGame);
        context.status(201);
        context.json(scheduledGame);
    }

    @OpenApi(
            path = "/games",
            method = HttpMethod.GET,
            description = "Functionality for retrieving an array of all games",
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Game.class, isArray = true))
            }
    )
    public static void getAllGames(Context context){
        context.json(schedulingService.getAllGames());
    }

    @OpenApi(
            path = "/seasons",
            method = HttpMethod.GET,
            description = "Functionality for retrieving an array of all seasons",
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Season.class, isArray = true))
            }
    )
    public static void getAllSeasons(Context context){
        context.json(schedulingService.getAllSeasons());
    }
}
