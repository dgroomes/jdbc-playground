package dgroomes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static dgroomes.Runner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CursorsTest {

    private static DestinationVisitor app;

    @BeforeAll
    public static void setup() throws Exception {
        var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        app = new DestinationVisitor(connection);
    }

    @Test
    void test() throws Exception {
        var rows = app.visit();

        assertEquals(10, rows);
    }
}
