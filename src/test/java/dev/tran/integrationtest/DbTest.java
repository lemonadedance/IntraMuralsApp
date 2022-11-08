package dev.tran.integrationtest;

import com.uni.datautils.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbTest {

    @Test
    public void test() {
        ConnectionUtil.getConnection();
    }

}
