package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.exceptions.DatabaseConnectionException;
import com.uni.entities.StatBasketball;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StatBasketballDAO implements CrudDAO<StatBasketball>{

    private static StatBasketballDAO statBasketballDAO = null;

    public static StatBasketballDAO getSingleton(){

        if(statBasketballDAO == null){
            statBasketballDAO = new StatBasketballDAO();
        }

        return statBasketballDAO;
    }

    private StatBasketballDAO() {}

    @Override
    public StatBasketball save(StatBasketball statBasketball) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "inser into stat_basketball values (default,)";


            throw new RuntimeException();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }

    }

    @Override
    public List<StatBasketball> findAll() {
        return null;
    }

    @Override
    public void update(StatBasketball statBasketball) {

    }
}
