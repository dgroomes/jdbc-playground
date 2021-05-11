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

See [select/README.md](select/README.md).

### `resultset-to-csv/`

This sub-project shows how to convert the `ResultSet` returned by JDBC into CSV-formatted output.

See [resultset-to-csv/README.md](resultset-to-csv/README.md).

## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* DONE Implement the `resultset-to-csv/` sub-project
* IN PROGRESS Implement a sub-project to iterate over a result set using a cursor 
  * I'm still not sure it's fetching incrementally or in one-shot..
