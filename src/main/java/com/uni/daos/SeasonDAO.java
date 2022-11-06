package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.exceptions.DatabaseConnectionException;
import com.uni.models.Season;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeasonDAO {

    public List<Season> getAll(){

        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "select * from season";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Season> seasons = new ArrayList();

            while (rs.next()){
                Season season = new Season(rs.getString("title"));
                seasons.add(season);
            }
            return seasons;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }

    }
}
