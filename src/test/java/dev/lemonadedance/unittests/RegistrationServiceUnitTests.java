package dev.lemonadedance.unittests;

import com.uni.services.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.uni.daos.*;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceUnitTests {

    @InjectMocks
    private static RegistrationServiceImpl rsi;

    @Mock
    private static TeamDAO mockTeamDAO;
    private static TeamRequestDAO mockTeamRequestDAO;
    private static UserDAO mockUserDAO;

    @BeforeAll
    public static void testSetUp(){
        mockTeamDAO = new TeamDAO(); //TeamDAO constructor is private
        mockTeamRequestDAO = new TeamRequestDAO(); //TeamRequestDAO constructor is private
        mockUserDAO = new UserDAO(); //UserDAO constructor is private
        rsi = new RegistrationServiceImpl(mockTeamDAO, mockUserDAO, mockTeamRequestDAO); //3 args
    }

    @BeforeEach
    public void mockObjects(){
        //
    }

    @Test
    public void registerTeamUnitTest(){
        //
    }

    @Test
    public void getUserFromLoginCredentialsUnitTest(){
        //
    }

    @Test
    public void registerUserUnitTest(){
        //
    }

    @Test
    public void updateUserUnitTest(){
        //
    }

    @Test
    public void retrieveAllUsersUnitTest(){
        //
    }

    @Test
    public void getAllTeamRequestsUnitTest(){
        //
    }

    @Test
    public void filterTeamRequestByTeamUnitTest(){
        //
    }

    @Test
    public void createRequestUnitTest(){
        //
    }

    @Test
    public void approveRequestUnitTest(){
        //
    }
}
