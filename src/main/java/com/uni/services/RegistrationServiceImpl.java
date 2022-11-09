package com.uni.services;

import com.uni.daos.TeamDAO;
import com.uni.daos.TeamRequestDAO;
import com.uni.daos.UserDAO;
import com.uni.dtos.LoginCredentials;
import com.uni.entities.ImUser;
import com.uni.entities.Team;
import com.uni.entities.TeamRequest;
import com.uni.exceptions.PasswordMismatchException;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService{

    private TeamDAO teamDAO;
    private UserDAO userDao;
    private TeamRequestDAO teamRequestDAO;

    public RegistrationServiceImpl(TeamDAO teamDAO, UserDAO userDao, TeamRequestDAO teamRequestDAO) {
        this.teamDAO = teamDAO;
        this.userDao = userDao;
        this.teamRequestDAO = teamRequestDAO;
    }

    @Override
    public Team registerTeam(Team team) {
        return this.teamDAO.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return this.teamDAO.findAll();
    }

    @Override
    public ImUser getUserFromLoginCredentials(LoginCredentials loginCredentials) {
        ImUser imUser = this.userDao.getByUsername(loginCredentials.getUsername());

        if(!imUser.getPassword().equals(loginCredentials.getPassword())){
            throw new PasswordMismatchException();
        }
        return imUser;
    }

    @Override
    public ImUser updateImUser(ImUser imUser) {
        return null;
    }

    @Override
    public ImUser createUser(ImUser imUser) {
        return null;
    }

    @Override
    public List<TeamRequest> getAllTeamRequests() {
        return this.teamRequestDAO.findAll();
    }

    @Override
    public TeamRequest createRequest(TeamRequest teamRequest) {
        teamRequest.setTeamRequestStatus("pending");
        return this.teamRequestDAO.save(teamRequest);
    }
}
