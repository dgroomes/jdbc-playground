# cursors

NOT YET IMPLEMENTED

This sub-project shows how to use a Postgres *cursor* to iterate over a result set from Java code.

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

### Reference

* [Postgres docs: *Cursors*](https://www.postgresql.org/docs/13/plpgsql-cursors.html)
  > Rather than executing a whole query at once, it is possible to set up a cursor that encapsulates the query, and then read the query result a few rows at a time. One reason for doing this is to avoid memory overrun when the result contains a large number of rows.
