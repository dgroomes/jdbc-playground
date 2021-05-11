package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static final String SETUP_SQL = """
            drop table if exists fortunes;
            create table fortunes (id integer, fortune string);
            insert into fortunes values
                (1, 'Today is going to be a pretty good day!'),
                (2, 'Tomorrow is going to be awesome!');
            """;

    public static void main(String[] args) {
        try (var connection = DriverManager.getConnection("jdbc:sqlite:fortunes.db");
             var statement = connection.createStatement()) {

            statement.executeUpdate(SETUP_SQL);
            var rs = statement.executeQuery("select id, fortune from fortunes");

            log.info("Found results...");
            while (rs.next()) {
                var fortune = new Fortune(rs.getInt("id"), rs.getString("fortune"));
                log.info(fortune.toString());
            }
        } catch (SQLException e) {
            log.error("Unexpected error while using the SQLite database", e);
        }
    }
}
