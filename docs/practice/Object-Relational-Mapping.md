# Object Relational Mapping

ORM — a concept of mapping objects to relational database tables. <br>
JPA — the ORM standard for Java. <br>
Hibernate — a popular JPA implementation. <br>

### Object-Relational Impedance Mismatch
- **Granularity:** There are usually more classes than corresponding database tables.
- **Inheritance:** Object-oriented inheritance does not directly map to relational database tables.
- **Associations:** Bi-directional associations in objects vs. foreign keys in relational databases.
- **Identity:** Object identity (using `==` and `.equals()`) versus primary keys in the database.
- **Data Navigation:** Navigating the object graph in memory vs. performing `SELECT` and `JOIN` queries in the database.
