# jdbc-playground

📚 Learning and exploring JDBC (Java Database Connectivity).

> The JDBC API is a Java API that can access any kind of tabular data, especially data stored in a Relational Database.
>
> -- <cite>https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html</cite>


## Standalone subprojects

This repository illustrates different concepts, patterns and examples via standalone subprojects. Each subproject is
completely independent of the others and do not depend on the root project. This _standalone subproject constraint_
forces the subprojects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The subprojects include:


### `select/`

This subproject illustrates a simple program that executes a `select * from ...` statement using JDBC.

See the README in [select/](select/).


### `cursors/`

This subproject shows how to use a Postgres *cursor* to iterate over a result set from Java code.

See the README in [cursors/](cursors/).


### `sqlite/`

A Java program that reads from a SQLite database. Remember, a SQLite database is just a file!

See the README in [sqlite/](sqlite/).


### `connection-check/`

Use the Postgres JDBC driver to check if the database can be connected to. Sometimes, this is called a *health check*.

See the README in [connection-check/](connection-check/).


## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Implement the `resultset-to-csv/` subproject
* [x] DONE Implement a subproject to iterate over a result set using a cursor 
  * (Update: Postgres JDBC driver uses JUL and you can see its activity that way) I'm still not sure it's fetching incrementally or in one-shot..
