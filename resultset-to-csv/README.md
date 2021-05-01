# resultset-to-csv

This sub-project shows how to convert the `ResultSet` returned by JDBC into CSV-formatted output.

---

### Instructions

Requires: Java 16, Docker

1. Start the Postgres database:
   * `docker-compose up --renew-anon-volumes --detach`
1. Run the program:
   * `./gradlew run`
1. Run the tests:
   * `./gradlew test`
1. Stop the database:
   * `docker-compose down`


### Notes

Interestingly, the Jackson serialization library does not accommodate serializing a JDBC `ResultSet` to CSV. See this
[GitHub issue](https://github.com/FasterXML/jackson-dataformat-csv/issues/154) for some background. By contrast, the
Apache library [commons-csv](https://github.com/apache/commons-csv) does have native support for this use case. In fact,
the implementation is very straightforward too which is in contrast to Jackson's highly layered object-oriented design
(which to be fair I assume allows Jackson to be very performant). Specifically, read the kernel of the `ResultSet`-to-CSV-serialization
code in [`CSVPrinter.printRecords()`](https://github.com/apache/commons-csv/blob/0aa7954bfab5c68e47742d342acf23fefc268269/src/main/java/org/apache/commons/csv/CSVPrinter.java#L380).  


### Referenced Material

* [GitHub issue: "Jdbc ResultSet to CSV"](https://github.com/FasterXML/jackson-dataformat-csv/issues/154)
* [GitHub issue: "Create `jackson-datatype-jdbc`?"](https://github.com/FasterXML/jackson-future-ideas/issues/2)
