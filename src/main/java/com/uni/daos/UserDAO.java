package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.exceptions.NoUsernameFoundException;
import com.uni.models.ImUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public ImUser getByUsername(String username){
        try(Connection connection = ConnectionUtil.getConnection()) {
            String sql = "select * from im_user where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ImUser user = new ImUser();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setHeightInches(rs.getInt("height"));
                user.setWeightLbs(rs.getInt("weight"));
                user.setProfilePic(rs.getString("profile_pic"));
                user.setHideBiometrics(rs.getBoolean("display_biometrics"));
                return user;
            }
            throw new NoUsernameFoundException();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
