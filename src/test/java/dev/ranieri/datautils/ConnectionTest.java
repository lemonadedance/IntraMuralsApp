package dev.ranieri.datautils;

import com.uni.daos.UserDAO;
import com.uni.datautils.ConnectionUtil;
import com.uni.models.ImUser;
import org.junit.jupiter.api.Test;

public class ConnectionTest {


    @Test
    void connects_to_database(){
        System.out.println(ConnectionUtil.getConnection());
    }

    @Test
    void sample(){
        UserDAO userDao = new UserDAO();
        ImUser user = userDao.getByUsername("gatorFan99");
        System.out.println(user);
    }
}
