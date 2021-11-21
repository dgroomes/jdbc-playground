package dgroomes;

import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A Java program that uses JDBC to check if a Postgres database is up. In other words: a *health check*.
 */
public class HealthCheckApp {

    public static void main(String... args) {
        var log = LoggerFactory.getLogger(HealthCheckApp.class);
        var logPreamble = "Postgres health check status: ";
        var jdbcUrl = "jdbc:postgresql:postgres";
        var username = "postgres";

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
            log.error(logPreamble + "COULD NOT CONNECT ❌");
        }
    }
}
