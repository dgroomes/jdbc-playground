package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Imaginary international destination visitor: visit destinations around the world!
 */
public class DestinationVisitor {

    private static final Logger log = LoggerFactory.getLogger(DestinationVisitor.class);

    private final Connection connection;

    /**
     * @param connection a JDBC connection to the Postgres database
     */
    public DestinationVisitor(Connection connection) {
        this.connection = connection;
    }

    private static final String SQL = "SELECT 1";

    /**
     * Visit all destinations in the "destinations" table. Visit them one-by-one, iterating over the result set by using
     * a "cursor". Because we are using a cursor, we do not need to pull the full result set into the Java program's
     * memory all at once. Instead, we just pull one row at a time from the result set.
     *
     * @return the number of destinations visited
     */
    public int visit() throws SQLException {
        log.info("Creating a cursor and using it to iterate over a result set... NOT YET IMPLEMENTED");
        try (var stmt = connection.createStatement();
             var rs = stmt.executeQuery(SQL)) {

            rs.next();
            return rs.getInt(1);
        }
    }
}
