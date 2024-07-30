# cursors

This subproject shows how to use a Postgres *cursor* to iterate over a result set from Java code.


## Instructions

Follow these instructions to run the demo.

1. Pre-requisite: Java 21, Docker
2. Start the Postgres database:
   * ```shell
     docker compose up --renew-anon-volumes --detach
     ```
3. Run the program:
   * ```shell
     ./gradlew run
     ```
   * Study the logs that are printed to the console. It shows that the program makes a new fetch request to the database
     between each "destination" that is visited. So, it is using a cursor!  
4. Run the tests:
   * ```shell
     ./gradlew test
     ```
5. Stop the database:
   * ```shell
     docker compose down
     ```


## Reference

* [Postgres docs: *Cursors*](https://www.postgresql.org/docs/13/plpgsql-cursors.html)
  > Rather than executing a whole query at once, it is possible to set up a cursor that encapsulates the query, and then read the query result a few rows at a time. One reason for doing this is to avoid memory overrun when the result contains a large number of rows.
* [Postgres JDBC docs: *Chapter 5. Issuing a Query and Processing the Result*](https://jdbc.postgresql.org/documentation/head/query.html)
  > By default the driver collects all the results for the query at once. This can be inconvenient for large data sets so the JDBC driver provides a means of basing a ResultSet on a database cursor and only fetching a small number of rows.
