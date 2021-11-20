# select

This sub-project illustrates a simple program that executes a `select * from ...` statement using JDBC.

---

### Instructions

Requires: Java 17, Docker

1. Start the Postgres database:
   * `docker-compose up --renew-anon-volumes --detach`
1. Run the program:
   * `./gradlew run`
1. Stop the database:
   * `docker-compose down`
