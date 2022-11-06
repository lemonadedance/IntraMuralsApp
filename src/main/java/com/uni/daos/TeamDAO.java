package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.exceptions.DatabaseConnectionException;
import com.uni.exceptions.TeamCreationException;
import com.uni.models.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    public Team createTeam(Team team){

        try(Connection connection = ConnectionUtil.getConnection()){
            String sql = "insert into team values (?,?,?::team_status,?::sport)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,team.getName());
            ps.setInt(2,team.getCaptain());
            ps.setString(3,team.getTeam_status());
            ps.setString(4,team.getSport());
            ps.executeUpdate();
            return team;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new TeamCreationException();
        }

    }

//    create table team(
//            name varchar primary key,
//            captain int references im_user(user_id),
//    team_status team_status,
//    sport sport
//);
    public List<Team> getAllTeams(){

        try(Connection connection = ConnectionUtil.getConnection()){
            String sql = "select * from team";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Team> teams = new ArrayList();

            while(rs.next()){
                Team team = new Team();
                team.setName(rs.getString("name"));
                team.setCaptain(rs.getInt("captain"));
                team.setTeamStatus(rs.getString("team_status"));
                team.setSport(rs.getString("sport"));
                teams.add(team);
            }

            return teams;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }
}
