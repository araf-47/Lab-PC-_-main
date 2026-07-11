With **12 hours**, you need to optimize for one thing:

> **Get one working CRUD application.** Don't try to understand every detail first.

Here's a practical schedule.

---

# Hour 1: Understand the Stack (30–60 minutes)

Know what each component does.

```
Browser
   ↓
Tomcat 9
   ↓
Servlet (Java)
   ↓
JDBC
   ↓
SQLite
```

Learn only these terms:

* Servlet
* JDBC
* SQLite
* Tomcat

Don't watch a 2-hour Java course. Just understand the flow.

---

# Hour 2: Learn Essential SQL

Practice these commands until you can type them without looking.

```sql
CREATE TABLE students(
    id INTEGER PRIMARY KEY,
    name TEXT,
    age INTEGER
);
```

```sql
INSERT INTO students(name, age)
VALUES ('Alice', 20);
```

```sql
SELECT * FROM students;
```

```sql
UPDATE students
SET age = 21
WHERE id = 1;
```

```sql
DELETE FROM students
WHERE id = 1;
```

```sql
DROP TABLE students;
```

If you're comfortable with these six commands, you've covered the SQL needed for basic CRUD.

---

# Hour 3: SQLite on Debian

Install SQLite if needed:

```bash
sudo apt install sqlite3
```

Open it:

```bash
sqlite3 students.db
```

Practice:

* Create a table
* Insert 5 students
* View them
* Update one
* Delete one
* Drop the table
* Recreate it

This helps you separate SQL problems from Java problems.

---

# Hour 4: Learn JDBC

Memorize this sequence:

```java
Connection
```

↓

```java
Statement
```

↓

```java
executeUpdate()
```

↓

```java
executeQuery()
```

↓

```java
ResultSet
```

↓

```java
close()
```

The basic pattern is:

```java
Connection con = DriverManager.getConnection(...);

Statement stmt = con.createStatement();

stmt.executeUpdate(sql);

con.close();
```

---

# Hour 5: Java + SQLite

Write one Java program (not a servlet yet) that:

1. Connects to SQLite
2. Creates the table
3. Inserts one row
4. Prints all rows
5. Closes the connection

If this works, you've already connected Java to the database.

---

# Hour 6: Tomcat and Servlets

Create a simple servlet.

Test it with:

```
http://localhost:8080/YourApp/hello
```

If the browser shows:

```
Hello World
```

your Tomcat setup is working.

---

# Hour 7: Insert from a Servlet

Replace "Hello World" with database code.

When the servlet runs:

```
Open database
↓

INSERT student

↓

Show "Inserted successfully"
```

Congratulations—you've done the "Create" part of CRUD.

---

# Hour 8: Read Data

Execute:

```sql
SELECT * FROM students;
```

Loop through the `ResultSet` and print something like:

```
1 Alice 20
2 Bob 22
```

You now have the "Read" part.

---

# Hour 9: Update and Delete

Practice:

```sql
UPDATE students
SET age = 25
WHERE id = 1;
```

and

```sql
DELETE FROM students
WHERE id = 1;
```

After each operation, use `SELECT *` to verify the change.

---

# Hour 10: Build a Mini Project

Create a simple Student Manager.

You only need four actions:

```
Add Student

↓

View Students

↓

Update Student

↓

Delete Student
```

It doesn't need to look nice.

Plain HTML is fine.

---

# Hour 11: Start Over

Without copying, try to rebuild:

* Database connection
* Create table
* Insert
* Select
* Update
* Delete

If you get stuck, check your earlier code.

This reinforces what you've learned.

---

# Hour 12: Review and Debug

Test everything:

* Can you connect to SQLite?
* Can you create a table?
* Can you insert a row?
* Can you view all rows?
* Can you update one row?
* Can you delete one row?
* Can you drop and recreate the table?

If all of these work, you've met your goal.

## Commands to Memorize

**SQL**

```sql
CREATE TABLE
INSERT INTO
SELECT * FROM
UPDATE
DELETE
DROP TABLE
```

**JDBC**

```java
Connection
Statement
PreparedStatement
ResultSet
executeQuery()
executeUpdate()
close()
```

**Servlet**

```java
doGet()

or

doPost()
```

## If You Have Zero Experience

Don't waste time reading long documentation. Build as you learn.

The fastest way is:

1. Create a table.
2. Write Java code to connect.
3. Insert one row.
4. Read it back.
5. Update it.
6. Delete it.

Once you've done those steps successfully, you understand the core of CRUD.

### One question before we go further:

**How are you developing this project?**

* Eclipse IDE
* IntelliJ IDEA
* VS Code
* Command line (`javac`)
* Another setup

Also, is your assignment using **Servlets + JSP**, or only **Servlets**? That will help me tailor the examples.
