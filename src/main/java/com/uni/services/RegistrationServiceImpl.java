package com.uni.services;

import com.uni.daos.TeamDAO;
import com.uni.daos.TeamRequestDAO;
import com.uni.daos.UserDAO;
import com.uni.dtos.LoginCredentials;
import com.uni.entities.ImUser;
import com.uni.entities.Team;
import com.uni.entities.TeamRequest;
import com.uni.exceptions.PasswordMismatchException;
import com.uni.exceptions.ResourceNotFoundException;

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

    @Override
    public TeamRequest approveRequest(int requestId) {

        TeamRequest teamRequest = null;

        for(TeamRequest t : teamRequestDAO.findAll()){
            if(t.getTeamRequestId() == requestId){
                teamRequest = t;
            }
        }
        if(teamRequest == null){
            throw new ResourceNotFoundException(requestId, TeamRequest.class);
        }
        teamRequest.setTeamRequestStatus("accepted");
        teamRequestDAO.update(teamRequest);

        return teamRequest;
    }

    @Override
    public TeamRequest denyRequest(int requestId) {
        TeamRequest teamRequest = null;

        for(TeamRequest t : teamRequestDAO.findAll()){
            if(t.getTeamRequestId() == requestId){
                teamRequest = t;
            }
        }
        if(teamRequest == null){
            throw new ResourceNotFoundException(requestId, TeamRequest.class);
        }
        teamRequest.setTeamRequestStatus("denied");
        teamRequestDAO.update(teamRequest);

        return teamRequest;
    }
}
