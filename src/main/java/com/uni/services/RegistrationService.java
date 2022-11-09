package com.uni.services;

import com.uni.dtos.LoginCredentials;
import com.uni.entities.ImUser;
import com.uni.entities.Team;

import java.util.List;

public interface RegistrationService {

    Team registerTeam(Team team);
    List<Team> getAllTeams();
    ImUser getUserFromLoginCredentials(LoginCredentials loginCredentials);
    ImUser updateImUser(ImUser imUser);
    ImUser createUser(ImUser imUser);

}
