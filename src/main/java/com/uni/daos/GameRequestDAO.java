package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.entities.GameRequest;
import com.uni.exceptions.DatabaseConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameRequestDAO implements CrudDAO<GameRequest> {

    private static GameRequestDAO gameRequestDAO = null;

    public static GameRequestDAO getSingleton(){
        if(gameRequestDAO == null){
            gameRequestDAO = new GameRequestDAO();
        }
        return gameRequestDAO;
    }
    @Override
    public GameRequest save(GameRequest gameRequest) {
        try(Connection connection = ConnectionUtil.getConnection()){
            String sql = "insert into game_requests values (default, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,gameRequest.getGameId());
            ps.setInt(2, gameRequest.getUserId());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int key = rs.getInt("game_request_id");
            gameRequest.setGameRequestId(key);

            return gameRequest;

        } catch (SQLException exception){
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    @Override
    public List<GameRequest> findAll() {
        try(Connection connection = ConnectionUtil.getConnection()){
            String sql = "select * from game_requests";
            List<GameRequest> gameRequests = new ArrayList<>();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                GameRequest gameRequest = new GameRequest();
                gameRequest.setGameRequestId(rs.getInt("game_request_id"));
                gameRequest.setGameId(rs.getInt("game"));
                gameRequest.setUserId(rs.getInt("user_id"));
                gameRequests.add(gameRequest);
            }
            return gameRequests;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    @Override
    public void update(GameRequest gameRequest) {

    }
}
