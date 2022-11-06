package com.uni.services;

import com.uni.daos.GameDAO;
import com.uni.daos.SeasonDAO;
import com.uni.daos.VenueDAO;
import com.uni.models.Game;
import com.uni.models.Season;
import com.uni.models.Venue;

import java.util.List;

public class SchedulingServiceImpl implements SchedulingService{

    private VenueDAO venueDAO;
    private GameDAO gameDAO;
    private SeasonDAO seasonDAO;

    public SchedulingServiceImpl(VenueDAO venueDAO, GameDAO gameDAO, SeasonDAO seasonDAO){
        this.venueDAO = venueDAO;
        this.gameDAO = gameDAO;
        this.seasonDAO = seasonDAO;
    }

    @Override
    public List<Venue> getAllVenues() {
        return this.venueDAO.readAllVenues();
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameDAO.getAll();
    }

    @Override
    public List<Season> getAllSeasons() {
        return this.seasonDAO.getAll();
    }

    @Override
    public Game scheduleGame(Game game) {
        return this.gameDAO.createGame(game);
    }
}
