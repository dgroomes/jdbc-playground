package dgroomes;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This Java program shows how to convert the `ResultSet` returned by JDBC into CSV-formatted output.
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static final String JDBC_URL = "jdbc:postgresql:postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = null;

    private final Connection connection;

    public App(Connection connection) {
        this.connection = connection;
    }

    public static void main(String... args) throws ClassNotFoundException, SQLException, IOException {
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

    private static final String SQL = """
            SELECT description, notes
            FROM observations
            where description = 'underwhelming observation'
            """;

    public String selectAnObservation() throws SQLException, IOException {
        try (var stmt = connection.createStatement();
             var rs = stmt.executeQuery(SQL)) {

            var stringBuilder = new StringBuilder();
            CSVPrinter csvPrinter = new CSVPrinter(stringBuilder, CSVFormat.POSTGRESQL_CSV.withHeader(rs));
            csvPrinter.printRecords(rs);
            csvPrinter.close();
            return stringBuilder.toString();
        }
    }
}
