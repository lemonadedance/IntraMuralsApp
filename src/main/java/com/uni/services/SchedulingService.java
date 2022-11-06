package com.uni.services;

import com.uni.models.Game;
import com.uni.models.Season;
import com.uni.models.Venue;

import java.util.List;

public interface SchedulingService {

    List<Venue> getAllVenues();
    List<Game> getAllGames();
    List<Season> getAllSeasons();
    Game scheduleGame(Game game);


}
