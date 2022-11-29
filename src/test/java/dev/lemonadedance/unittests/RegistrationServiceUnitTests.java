package dev.lemonadedance.unittests;

import com.uni.entities.*;
import com.uni.services.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.uni.daos.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceUnitTests {

    @InjectMocks
    private static RegistrationServiceImpl rsi;

    @Mock
    private static TeamDAO mockTeamDAO;
    private static TeamRequestDAO mockTeamRequestDAO;
    private static UserDAO mockUserDAO;

    private static Team mockTeam;
    private static TeamRequest mockTeamRequest;
    private static ImUser mockUser;

    @BeforeAll
    public static void testSetUp(){
        mockTeamDAO = new TeamDAO(); //TeamDAO constructor was private and was using a singleton
        mockTeamRequestDAO = new TeamRequestDAO(); //TeamRequestDAO constructor was private and was using a singleton
        mockUserDAO = new UserDAO(); //UserDAO constructor was private and was using a singleton
        rsi = new RegistrationServiceImpl(mockTeamDAO, mockUserDAO, mockTeamRequestDAO); //3 args
    }

    @BeforeEach
    public void mockObjects(){
      mockUser = new ImUser(1, "clairehawks", "reallycoolpassword", "captain", 66, 135, "http://google.com", true);
      mockTeamRequest = new TeamRequest(2, "Austin Hawks", 1, "Pending");
      mockTeam = new Team("Austin Hawks", 3, "flag football", "active");
    }

    @Test
    public void registerTeamUnitTest(){
        assertNotNull(mockTeam);
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
