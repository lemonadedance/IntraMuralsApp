package com.uni.controllers;

import com.uni.services.GameRequestService;
import io.javalin.http.Context;

public class GameRequestController {
    private GameRequestService gameRequestService;

    public GameRequestController(GameRequestService gameRequestService) { this.gameRequestService = gameRequestService; }

    public void retrieveAllRefereeAndGames(Context context) { context.json(gameRequestService.getAllGamesAndReferees()); }
}
