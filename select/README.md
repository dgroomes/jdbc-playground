# select

This sub-project illustrates a simple program that executes a `select * from ...` statement using JDBC.

---

### Instructions

Requires: Java 15, Docker

1. Use Java 15
1. Start the Postgres database with `docker-compose up --renew-anon-volumes --detach`
1. Run the program with `./gradlew run`
1. Stop the database with `docker-compose down`
