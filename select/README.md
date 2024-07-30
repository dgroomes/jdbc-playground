# select

This subproject illustrates a simple program that executes a `select * from ...` statement using JDBC.

---

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
4. Stop the database:
   * ```shell
     docker compose down
     ```
