package com.uni.services;

import com.uni.daos.TeamDAO;
import com.uni.daos.UserDAO;
import com.uni.dtos.LoginCredentials;
import com.uni.entities.ImUser;
import com.uni.entities.Team;
import com.uni.exceptions.PasswordMismatchException;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService{

    private TeamDAO teamDAO;
    private UserDAO userDao;

    public RegistrationServiceImpl(TeamDAO teamDAO, UserDAO userDao) {
        this.teamDAO = teamDAO;
        this.userDao = userDao;
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
}
