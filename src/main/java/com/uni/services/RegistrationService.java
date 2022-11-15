package com.uni.services;

import com.uni.dtos.LoginCredentials;
import com.uni.dtos.PlayerCard;
import com.uni.entities.ImUser;
import com.uni.entities.Team;
import com.uni.entities.TeamRequest;

import java.util.List;

public interface RegistrationService {

    Team registerTeam(Team team);
    List<Team> getAllTeams();
    ImUser getUserFromLoginCredentials(LoginCredentials loginCredentials);


    ImUser registerUser(ImUser registrationInfo);

    List<TeamRequest> getAllTeamRequests();
    List<TeamRequest> filterTeamRequestsByTeam(String team);
    TeamRequest createRequest(TeamRequest teamRequest);
    TeamRequest approveRequest(int TeamRequest);
    TeamRequest denyRequest(int TeamRequest);
    

}
