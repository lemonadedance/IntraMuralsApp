package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.entities.RefereeLookup;
import com.uni.exceptions.DatabaseConnectionException;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefereeLookupDAO implements CrudDAO<RefereeLookup>{
    private static RefereeLookupDAO refereeLookupDAO = null;

    public static RefereeLookupDAO getSingleton(){
        if(refereeLookupDAO == null){
            refereeLookupDAO = new RefereeLookupDAO();
        }
        return refereeLookupDAO;
    }
    private RefereeLookupDAO(){}

    @Override
    public RefereeLookup save(RefereeLookup refereeLookup) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into referee_lookup values (default, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, refereeLookup.getGameRefereeId());
            ps.setInt(2, refereeLookup.getGameId());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("referee_lookup_id");
            refereeLookup.setRefereeLookUpId(key);
            return refereeLookup;

        } catch (SQLException exception){
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    @Override
    public List<RefereeLookup> findAll() {
        try(Connection connection = ConnectionUtil.getConnection()){
            String sql = "select * from referee_lookup";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<RefereeLookup> refereeLookups = new ArrayList<>();

            while(rs.next()){
                RefereeLookup refereeLookup = new RefereeLookup();
                refereeLookup.setRefereeLookUpId(rs.getInt("referee_lookup_id"));
                refereeLookup.setGameRefereeId(rs.getInt("user_id"));
                refereeLookup.setGameId(rs.getInt("game_id"));
                refereeLookups.add(refereeLookup);
            }
            return refereeLookups;
        } catch (SQLException exception){
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    @Override
    public void update(RefereeLookup refereeLookup) {

    }

}
