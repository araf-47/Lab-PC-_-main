### Using
`using` clause.

```sql
SELECT l.city, d.department_name 
FROM locations l JOIN departments d
USING (location_id)
WHERE location_id = 1400;
```

***
## Display employees who get less than average salary among the same job_title.
```sql
SELECT e.first_name, e.last_name, j.job_title, e.salary
FROM employees e JOIN jobs j 
ON e.job_id = j.job_id
WHERE e.salary < (SELECT AVG(salary) FROM employees WHERE job_id = e.job_id);
```

Let’s break your query down in a very simple way 👇

---

### 🧠 What you’re trying to do

Show employees whose **salary is below the average salary of people doing the same job**.

---

### 🔍 Step-by-step explanation

#### 1. FROM + JOIN

```sql
FROM employees e JOIN jobs j 
ON e.job_id = j.job_id
```

👉 You’re combining two tables:

- `employees` → has employee info (name, salary, job_id)
    
- `jobs` → has job titles
    

✅ Result: Each employee now also shows their **job_title** instead of just `job_id`.

---

#### 2. SELECT

```sql
SELECT e.first_name, e.last_name, j.job_title, e.salary
```

👉 You choose what to display:

- Employee name
    
- Job title
    
- Salary
    

---

#### 3. WHERE condition (this is the key part)

```sql
WHERE e.salary < (
    SELECT AVG(salary)
    FROM employees
    WHERE job_id = e.job_id
);
```

This part works **row by row**.

---

### 💡 Think of it like this:

For each employee:

1. Take their `job_id`
    
2. Run the subquery:
    
    ```sql
    SELECT AVG(salary)
    FROM employees
    WHERE job_id = e.job_id
    ```
    
    👉 This calculates the **average salary for that specific job**
    
3. Compare:
    
    - Employee’s salary  
        vs
        
    - Average salary for that job
        
4. If:
    
    ```
    employee salary < average salary
    ```
    
    ✅ include them in the result
    

---

### 🧾 Simple example

Suppose job = "IT_PROG":

| Name | Salary |
| ---- | ------ |
| A    | 6000   |
| B    | 8000   |
| C    | 10000  |


👉 Average = 8000

So your query returns:

- A (6000 < 8000 ✅)
    
- B (8000 ❌ not less)
    
- C (10000 ❌)
    

---

### 🔁 Important concept: Correlated subquery

This part:

```sql
WHERE job_id = e.job_id
```

👉 makes the subquery depend on the **current row**

That’s why it recalculates the average **for each employee’s job**.

---

### 🧩 One-line intuition

👉 “For each employee, compare their salary to the average salary of people with the same job, and show them if they earn less.”

## cartesian products
==Cross Joint লাগে না so বাদ দেন পড়ার দরকার নাই==
