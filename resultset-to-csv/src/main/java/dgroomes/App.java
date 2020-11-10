package dgroomes;

import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Illustrates a simple program that executes a `select * from ...` statement using JDBC.
 */
public class App {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

    public static final String JDBC_URL = "jdbc:postgresql:postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = null;

    private final Connection connection;

    public App(Connection connection) {
        this.connection = connection;
    }

    public static void main(String... args) throws ClassNotFoundException, SQLException {
        /*
         * Load the Postgres JDBC driver class to exercise its static initializers so that it becomes registered in
         * the DriverManager
         */
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        var app = new App(connection);

        var observation = app.selectAnObservation();
        log.info("Found this observation:\n{}", observation);
    }

    public String selectAnObservation() throws SQLException {
        var stmt = connection.createStatement();
        var rs = stmt.executeQuery("""
                SELECT description, notes
                FROM observations
                where description = 'underwhelming observation'
                """);

        rs.next();
        var description = rs.getString("description");
        var notes = (String[]) rs.getArray("notes").getArray();
        return String.format("description: %s\nnotes: %s", description, Arrays.toString(notes));
    }
}
