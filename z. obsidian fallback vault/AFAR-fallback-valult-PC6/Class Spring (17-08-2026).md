## Hibernate
It is also a framework. establish relation mapping on objects.

### ORM
ORM stands for Object-Relational Mapping. It is a tool and programming technique that lets you connect and manage data in a relational database using the same object-oriented code from your programming language (like Python, JavaScript, or Java), without writing manual SQL queries.

- Benefits
	- don't have to write database specific query.
	- no need to write database specific configuration.

1. step: make the xml file. `hibernate.cfg.xml`.

- hibernate utility.
	- service registry loads configuration files.

session factory : only job is to create session.

- **HQL** : hibernate query language. 
	- starts with `from` not `select`.
	- `query.list`.