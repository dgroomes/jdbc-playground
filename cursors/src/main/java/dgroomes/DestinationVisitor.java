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
    private static final int FETCH_SIZE = 1;

    private final Connection connection;

    public DestinationVisitor() {
        this.connection = DbUtil.createConnection();
        try {
            this.connection.setAutoCommit(false); // Auto commit must be false to allow fetches to respect fetch size and use cursors
        } catch (SQLException exception) {
            throw new IllegalStateException("Something went wrong when setting 'auto commit'", exception);
        }
    }

    // Select a sample of rows from the "destinations" table
    private static final String SELECT_SAMPLE_OF_DESTINATIONS = """
            select name, region
            from destinations
            order by name limit 10
            """;

    /**
     * Visit all destinations in the "destinations" table. Visit them one-by-one, iterating over the result set by using
     * a "cursor". Because we are using a cursor, we do not need to pull the full result set into the Java program's
     * memory all at once. Instead, we just pull one row at a time from the result set.
     * <p>
     * The JDBC API and the Postgres JDBC driver abstract cursors away from the programmer. A cursor is not used explicitly
     * but rather implicitly by setting the fetch size on the statement to a non-zero value. Read about this behavior in
     * the Postgres JDBC guide: https://jdbc.postgresql.org/documentation/head/query.html and specifically the "Getting results based on a cursor"
     * section.
     *
     * @return the number of destinations visited
     */
    public int visit() {
        log.info("Visiting (iterating over) destinations");
        int count = 0;
        try (var stmt = connection.createStatement()) {
            stmt.setFetchSize(FETCH_SIZE);
            try (var rs = stmt.executeQuery(SELECT_SAMPLE_OF_DESTINATIONS)) {

                while (rs.next()) {
                    count++;

                    var name = rs.getString(1);
                    var region = rs.getString(2);
                    var destination = new Destination(name, region);

                    log.info("Visiting {}", destination);
                }
            }
        } catch (SQLException exception) {
            throw new IllegalStateException("Something went wrong while trying to visit the destinations", exception);
        }
        return count;
    }
}
