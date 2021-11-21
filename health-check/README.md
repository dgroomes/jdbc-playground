# health-check

A Java program that uses JDBC to check if a Postgres database is up. In other words: a *health check*.

---

### Instructions

Requires: Java 17, Docker

1. Run the program:
   * `./gradlew run`
   * Notice from the log output that the health check yielded a "COULD NOT CONNECT ❌" message. 
2. Start the Postgres database:
   * `docker-compose up --renew-anon-volumes --detach`
3. Run the program:
   * `./gradlew run`
   * Notice from the log output that the health check yielded an "UP ✅" message. 
4. Stop the database:
   * `docker-compose down`

All put together, it will output something like this:

```bash
./gradlew run

> Task :run
[main] ERROR dgroomes.HealthCheckApp - Postgres health check status: COULD NOT CONNECT ❌
[main] ERROR dgroomes.HealthCheckApp - Postgres health check status: COULD NOT CONNECT ❌
[main] ERROR dgroomes.HealthCheckApp - Postgres health check status: COULD NOT CONNECT ❌
[main] INFO dgroomes.HealthCheckApp - Postgres health check status: UP ✅
[main] INFO dgroomes.HealthCheckApp - Postgres health check status: UP ✅
[main] ERROR dgroomes.HealthCheckApp - Postgres health check status: COULD NOT CONNECT ❌
[main] ERROR dgroomes.HealthCheckApp - Postgres health check status: COULD NOT CONNECT ❌
```

## Notes

What is the idiomatic way to do a health check? I know I can just do a toy statement like `select 1` but I wonder if
there is a convenience method on the Postgres JDBC API that does an idiomatic health check? Or a more general
diagnostic check? Update: I found support for the `select 1` approach and I also found the convenience method `org.postgresql.util.PSQLState.isConnectionError`
for checking if an exception is connection-related or something else. I think that's the gist of it.

## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* DONE Check continuously
* Add to the instructions to start the health check program, then over time start/stop the Postgres database and observe
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
