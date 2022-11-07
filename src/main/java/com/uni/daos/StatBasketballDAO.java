package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.exceptions.DatabaseConnectionException;
import com.uni.models.StatBasketball;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StatBasketballDAO implements CrudDAO<StatBasketball>{

    //    create table stat_basketball(
//        s_basketball_id serial primary key,
//        user_id int references im_user(user_id),
//    game_id int references game(game_id),
//            team_name varchar references team(name),
//            points int,
//            rebounds int,
//            assists int,
//            fouls int
//            );

    @Override
    public StatBasketball createInstance(StatBasketball statBasketball) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "inser into stat_basketball values (default,)";


            throw new RuntimeException();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }

    }

    @Override
    public List<StatBasketball> getAll() {
        return null;
    }
}
