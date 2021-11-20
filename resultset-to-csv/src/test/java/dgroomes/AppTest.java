package dgroomes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import static dgroomes.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static App app;

    @BeforeAll
    public static void setup() throws ClassNotFoundException, SQLException {
        /*
         * Load the Postgres JDBC driver class to exercise its static initializers so that it becomes registered in
         * the DriverManager. Update: I don't think this is needed. I think the JDBC API and JDBC driver implementations
         * dropped this standard years ago in favor of a ServiceLoader mechanism.
         */
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        app = new App(connection);
    }

    @Test
    void test() throws SQLException, IOException {
        var observation = app.selectAnObservation();

        var expected = """
                "description","notes"
                "underwhelming observation","{""the sky is there"",""cats are not dogs""}"
                """;
        assertEquals(expected, observation);
    }
}
