`gemini`
Got it! Tomcat 9.x is a fantastic choice for this. It runs on the Java EE 8 standard (using the `javax.servlet` namespace), which is highly stable and widely documented.

To help you visualize how this all fits together in Tomcat before we dive into the code, here is how the architecture looks:

Let's jump straight into **Hour 1 & 2** combined. We will set up your project structure for Tomcat 9 and write the core Database logic.

---

## 📁 Step 1: The Tomcat 9 Project Structure

In your IDE (like Eclipse or IntelliJ), create a **Dynamic Web Project** targeting **Apache Tomcat v9.0**. Your folder structure must look exactly like this:

```text
MyJSPCrudApp/
├── src/main/java/
│   └── com/crud/
│       ├── model/
│       │   └── User.java
│       └── dao/
│           └── UserDAO.java
└── src/main/webapp/
    ├── WEB-INF/
    │   └── lib/
    │       ├── sqlite-jdbc-3.x.x.jar  <-- Put SQLite Driver Here!
    │       └── jstl-1.2.jar           <-- Put JSTL Library Here!
    ├── index.jsp                      <-- Displays user list
    └── user-form.jsp                  <-- Add / Edit Form

```

> ⚠️ **Critical Step for Tomcat:** You **must** download the SQLite JDBC `.jar` and the JSTL 1.2 `.jar` files and drop them directly into the `src/main/webapp/WEB-INF/lib/` folder. Tomcat relies on this folder to load external libraries at runtime.

---

## ☕ Step 2: The Model (`User.java`)

Create this plain Java class inside `com.crud.model`. It acts as a blueprint for the data holding a user's information.

```java
package com.crud.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String country;

    // Constructor for adding a new user (No ID needed, SQLite generates it)
    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    // Constructor for editing/fetching a user (ID included)
    public User(int id, String name, String email, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}

```

---

## 🔌 Step 3: The Connection & Read Logic (`UserDAO.java`)

Now let's write the `UserDAO.java` inside `com.crud.dao`. This file handles the direct connection to your SQLite database file and fetches the list of users.

```java
package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.crud.model.User;

public class UserDAO {
    
    // SQLite connection URL. This will automatically create 'crudapp.db' in your C:/ folder.
    // Mac/Linux users, use: "jdbc:sqlite:/Users/yourname/crudapp.db"
    private static final String jdbcURL = "jdbc:sqlite:C:/sqlite/crudapp.db";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Force Tomcat to load the SQLite Driver class
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(jdbcURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // READ Method: Fetch all users
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        // Using try-with-resources automatically closes connections to prevent SQLite locking!
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}

```

---

## 🛠️ Quick Checkpoint before Hour 3

Before we make the web pages, we need to ensure the database table actually exists. You can add a quick initialization block inside your DAO or run this setup SQL directly in your SQLite terminal/browser tool:

```sql
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    country TEXT NOT NULL
);

```

Ready to move into **Hour 3** to build the JSP frontend (`index.jsp`) and see your Tomcat server pull data dynamically?