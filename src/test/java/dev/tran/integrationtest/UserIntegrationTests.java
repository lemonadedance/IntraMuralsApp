package dev.tran.integrationtest;

import com.uni.controllers.SchedulingController;
import com.uni.controllers.TeamController;
import com.uni.controllers.UserController;
import com.uni.datautils.ConnectionUtil;
import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.javalin.test.JavalinTest;
import io.swagger.v3.oas.models.info.Info;
import okhttp3.Response;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserIntegrationTests {
    @BeforeEach
    public void populateDatabase() {
        ConnectionUtil.populateH2Database(ConnectionUtil.getConnection());
    }

    @AfterEach
    public void clearDatabase() {
        ConnectionUtil.clearH2Database(ConnectionUtil.getConnection());
    }
    
    @Test
    public void demo() {
        JavalinTest.test((app, client) -> {
            app.post("/login", UserController::login);

            Map<String, String> requestJson = new HashMap<>();
            requestJson.put("username", "testing123");
            requestJson.put("password", "12345");

            Response resp = client.post("/login", Collections.emptyMap(), Collections.emptyMap(), requestJson);

            String actualResponseJson = resp.body().string();
            String expectedResponseJson = "{\"userId\":1,\"username\":\"testing123\",\"password\":\"12345\",\"role\":\"player\",\"heightInches\":70,\"weightLbs\":150,\"profilePic\":null,\"hideBiometrics\":true}";

            Assertions.assertEquals(expectedResponseJson, actualResponseJson);
        });
    }

}
