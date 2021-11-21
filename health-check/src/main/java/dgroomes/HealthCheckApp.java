package dgroomes;

import org.postgresql.util.PSQLState;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A Java program that uses JDBC to check if a Postgres database is up. In other words: a *health check*.
 */
public class HealthCheckApp {

    public static void main(String... args) throws InterruptedException {
        var log = LoggerFactory.getLogger(HealthCheckApp.class);
        var logPreamble = "Postgres health check status: ";
        var jdbcUrl = "jdbc:postgresql:postgres";
        var username = "postgres";

        for (int i = 0; i < 10; i++, Thread.sleep(5_000)) {
            try (var connection = DriverManager.getConnection(jdbcUrl, username, null);
                 var statement = connection.createStatement();
                 var resultSet = statement.executeQuery("SELECT 1")) {

                resultSet.next();
                int found = resultSet.getInt(1);
                if (found == 1) {
                    log.info(logPreamble + "UP ✅");
                } else {
                    log.error(logPreamble + "UNEXPECTED RESPONSE ❌");
                }
            } catch (SQLException e) {
                if (PSQLState.isConnectionError(e.getSQLState())) {
                    log.error(logPreamble + "COULD NOT CONNECT ❌");
                } else {
                    log.error(logPreamble + "UNEXPECTED EXCEPTION ❌", e);
                }
            }
        }
    }
}
