package dgroomes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database utility functions and configuration
 */
public class DbUtil {

    public static final String JDBC_URL = "jdbc:postgresql:postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = null;

    public static Connection createConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException exception) {
            throw new IllegalStateException("Something went wrong when creating a connection.", exception);
        }
    }
}
