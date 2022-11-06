package com.uni.controllers;

import com.uni.daos.GameDAO;
import com.uni.daos.SeasonDAO;
import com.uni.daos.VenueDAO;
import com.uni.models.Game;
import com.uni.services.SchedulingService;
import com.uni.services.SchedulingServiceImpl;
import io.javalin.http.Context;

public class SchedulingController {


    private static SchedulingService schedulingService = new SchedulingServiceImpl(new VenueDAO(), new GameDAO(), new SeasonDAO());

    public static void getAllVenues(Context context){
        context.json(schedulingService.getAllVenues());
    }

    public static void scheduleGame(Context context){
        Game incomingGame = context.bodyAsClass(Game.class);
        Game scheduledGame = schedulingService.scheduleGame(incomingGame);
        context.status(201);
        context.json(scheduledGame);
    }

    public static void getAllGames(Context context){
        context.json(schedulingService.getAllGames());
    }

    public static void getAllSeasons(Context context){
        context.json(schedulingService.getAllSeasons());
    }
}
