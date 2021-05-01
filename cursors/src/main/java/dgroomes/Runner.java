package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This Java program shows how to create a "cursor" to iterate over a SQL result set from a Postgres database.
 */
public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    public static final String JDBC_URL = "jdbc:postgresql:postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = null;

    public static void main(String... args) throws ClassNotFoundException, SQLException, IOException {
        /*
         * Load the Postgres JDBC driver class to exercise its static initializers so that it becomes registered in
         * the DriverManager
         */
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        var app = new DestinationVisitor(connection);

        var rows = app.visit();
        log.info("Iterated over this many rows: {}", rows);
    }
}
