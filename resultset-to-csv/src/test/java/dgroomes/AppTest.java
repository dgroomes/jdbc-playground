package dgroomes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
         * the DriverManager
         */
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        app = new App(connection);

    }

    @Disabled
    @Test
    void test() throws SQLException {
        var observation = app.selectAnObservation();

        var expected = """
                underwhelming observation\tthe sky is there,cats are not dogs"
                """;
        assertEquals(expected, observation);
    }
}
