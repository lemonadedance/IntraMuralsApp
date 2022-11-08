package com.uni.services;

import com.uni.daos.TeamDAO;
import com.uni.models.Team;

import java.util.List;

public class TeamServiceImpl implements TeamService{

    private TeamDAO teamDAO;

    public TeamServiceImpl(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public Team registerTeam(Team team) {
        return this.teamDAO.createInstance(team);
    }

    public List<Team> getAllTeams(){
        return this.teamDAO.getAll();
    }
}
