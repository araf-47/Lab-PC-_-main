
### Insert
```sql
insert into countries (country_id, country_name) values ('BD', 'Bangladesh');
insert into countries values ('ZD', 'Zangladesh', 3);
```

### Create table
```sql
create table sales_reps ("id" NUMBER(6,0), "name" VARCHAR2(20 BYTE), "salary" NUMBER(8,2), "commission_pct" NUMBER(2,2));
```

### Insert from another table (copy)
```sql
insert into sales_reps ("id", "name", "salary", "commission_pct")
select employee_id, last_name, salary, commission_pct
from employees
where job_id = 'SA_REP';
```

```sql
-- online free sql
insert into SALES_REPS ("id", "name", "salary", "commission_pct")
SELECT employee_id, first_name || ' ' || last_name, salary, commission_pct
from EMPLOYEES;
```