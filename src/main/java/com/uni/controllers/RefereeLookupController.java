package com.uni.controllers;

import com.uni.services.RefereeLookupService;
import io.javalin.http.Context;

public class RefereeLookupController {
    private RefereeLookupService refereeLookupService;

    public RefereeLookupController(RefereeLookupService refereeLookupService){ this.refereeLookupService = refereeLookupService; }

    public void retrieveAllRefereeAndGames(Context context) { context.json(refereeLookupService.getAllGamesAndReferees()); }
}
