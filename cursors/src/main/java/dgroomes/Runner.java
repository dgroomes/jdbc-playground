package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * This Java program shows how to create a "cursor" to iterate over a SQL result set from a Postgres database.
 */
public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String... args) {
            var visitor = new DestinationVisitor();
            var rows = visitor.visit();
            log.info("Iterated over this many rows: {}", rows);
    }
}
