package com.uni.services;

import com.uni.models.Team;

import java.util.List;

public interface TeamService {

    Team registerTeam(Team team);

    List<Team> getAllTeams();
}
