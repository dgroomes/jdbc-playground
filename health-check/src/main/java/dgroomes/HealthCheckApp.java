package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A Java program that uses JDBC to check if a Postgres database is up. In other words: a *health check*.
 */
public class HealthCheckApp {

    private static final Logger log = LoggerFactory.getLogger(HealthCheckApp.class);

    private static final String JDBC_URL = "jdbc:postgresql:postgres";

    private final Connection connection;

    public HealthCheckApp(Connection connection) {
        this.connection = connection;
    }

    private static final String PREAMBLE = "Postgres health check status: ";

    public static void main(String... args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, "postgres", null);
        } catch (SQLException e) {
            log.error(PREAMBLE + "COULD NOT CONNECT ❌");
            System.exit(0);
        }

        var app = new HealthCheckApp(connection);
        app.healthCheck();
    }

    private void healthCheck() {
        try (var stmt = connection.createStatement();
             var rs = stmt.executeQuery("SELECT 1")) {

            rs.next();
            int found = rs.getInt(1);
            if (found == 1) {
                log.info(PREAMBLE + "UP ✅");
            } else {
                log.error(PREAMBLE + "UNEXPECTED RESPONSE ❌");
            }
        } catch (SQLException e) {
            log.error(PREAMBLE + "EXCEPTION ❌", e);
        }
    }
}
