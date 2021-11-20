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

## Notes

What is the idiomatic way to do a health check? I know I can just do a toy statement like `select 1` but I wonder if
there is a convenience method on the Postgres JDBC API that does an idiomatic health check? Or a more general
diagnostic check?

## Reference

* [CitusData: "A health check playbook for your Postgres database"](https://www.citusdata.com/blog/2019/03/29/health-checks-for-your-postgres-database/)
  * This is a different kind of health check than the "up check" I'm looking for. 
* [StackOverflow answer](https://stackoverflow.com/a/9602491)
  * Upvotes for the `select 1` approach. 
