# jdbc-playground

📚 Learning and exploring JDBC (Java Database Connectivity).

> The JDBC API is a Java API that can access any kind of tabular data, especially data stored in a Relational Database.
>
> -- <cite>https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html</cite>

## Standalone sub-projects

This repository illustrates different concepts, patterns and examples via standalone sub-projects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the sub-projects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The sub-projects include:

### `select/`

This sub-project illustrates a simple program that executes a `select * from ...` statement using JDBC.

See the README in [select/](select/).

### `resultset-to-csv/`

This sub-project shows how to convert the `ResultSet` returned by JDBC into CSV-formatted output.

See the README in [resultset-to-csv/](resultset-to-csv/).

### `cursors/`

This sub-project shows how to use a Postgres *cursor* to iterate over a result set from Java code.

See the README in [cursors/](cursors/).

### `sqlite/`

A Java program that reads from a SQLite database. Remember, a SQLite database is just a file!

See the README in [sqlite/](sqlite/).

### `health-check/`

A Java program that uses JDBC to check if a Postgres database is up. In other words: a *health check*.

See the README in [health-check/](health-check/).


## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* DONE Implement the `resultset-to-csv/` sub-project
* DONE Implement a sub-project to iterate over a result set using a cursor 
  * (Update: Postgres JDBC driver uses JUL and you can see its activity that way) I'm still not sure it's fetching incrementally or in one-shot..
