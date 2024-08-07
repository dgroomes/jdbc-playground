# connection-check

Use the Postgres JDBC driver to check if the database can be connected to. Sometimes, this is called a *health check*.


## Overview

This is a "hello world"-style Java program that showcases connecting to a database using JDBC. Between the Java code,
the Gradle configuration, and the Docker Compose configuration, there is plenty of boilerplate to get through.


## Instructions

Follow these instructions to run the example.

1. Pre-requisite: Java 21, Docker
2. Start the connection-check program:
   * ```shell
     ./gradlew run
     ```
   * Notice from the log output that the connection check yields a "COULD NOT CONNECT ❌" message.
3. Start the Postgres database:
   * Open a new command-line window or tab and execute the following Docker command to start a Postgres database. 
   * ```shell
     docker compose up --renew-anon-volumes --detach
     ```
   * Wait for a few seconds, and notice that the connection check is now yielding an "UP ✅" message! 
4. Stop the database:
   * ```shell
     docker compose down
     ```

Altogether, the connection-check program will output something like this:

```text
./gradlew run

> Task :run
[main] ERROR dgroomes.ConnectionCheckApp - Postgres connection-check: COULD NOT CONNECT ❌
[main] ERROR dgroomes.ConnectionCheckApp - Postgres connection-check: COULD NOT CONNECT ❌
[main] INFO dgroomes.ConnectionCheckApp - Postgres connection-check: UP ✅
[main] INFO dgroomes.ConnectionCheckApp - Postgres connection-check: UP ✅
[main] ERROR dgroomes.ConnectionCheckApp - Postgres connection-check: COULD NOT CONNECT ❌
[main] ERROR dgroomes.ConnectionCheckApp - Postgres connection-check: COULD NOT CONNECT ❌
```


## Notes

What is the idiomatic way to do a health check? I know I can just do a toy statement like `select 1` but I wonder if
there is a convenience method on the Postgres JDBC API that does an idiomatic health check? Or a more general
diagnostic check? Update: I found support for the `select 1` approach and I also found the convenience method `org.postgresql.util.PSQLState.isConnectionError`
for checking if an exception is connection-related or something else. I think that's the gist of it.


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Check continuously
* [x] DONE Add to the instructions to start the connection check program, then over time start/stop the Postgres database and observe
  the connection status (consider renaming to "connection check" instead of "health check"? Health check has better
  marketing)


## Reference

* [The Postgres JDBC Driver GitHub repo: "pgjdbc/pgjdbc"](https://github.com/pgjdbc/pgjdbc)
  * Wow, this repo is using modern Gradle tooling like `buildSrc` and dependency constraints. I'm surprised to see that
    for such an old project. Also, I didn't realize [r2dbc-postgresql](https://github.com/pgjdbc/r2dbc-postgresql)
    (reactive driver) is in the same GitHub org. I always assumed it was developed externally from the official Postgres
    projects. Good stuff.  
* [CitusData: "A health check playbook for your Postgres database"](https://www.citusdata.com/blog/2019/03/29/health-checks-for-your-postgres-database/)
  * This is a different kind of health check than the "up check" I'm looking for. 
* [StackOverflow answer](https://stackoverflow.com/a/9602491)
  * Upvotes for the `select 1` approach. 
