
```sql
update sales_reps2 set salary = 10000
where id in(151, 152, 153, 154);
```
### Update table
```sql
update sales_reps2
set (salary, commission_pct) = (select salary, commission_pct from sales_reps2 where id = 158) -- 9000, 0.35
where id = 175;

update sales_reps2
set
commission_pct = (select commission_pct from sales_reps2 where id = 150),-- 0.3
salary = (select salary from sales_reps2 where id = 150)-- 10000
where id = 179;
```
### delete table
```
delete from sales_reps;
```
### drop table
```sql
drop table sales_reps;
```

```sql
create table sales_reps3(
    id NUMBER(6,0), 
    name varchar2(60), 
    salary NUMBER(8, 2), 
    commission number(2, 2), 
    CONSTRAINT "pk_id" primary key (id)
);
```

### primary key
```sql
create table sales_reps3(
    id NUMBER(6,0), 
    name varchar2(60), 
    salary NUMBER(8, 2), 
    commission number(2, 2) default 0.0, 
    CONSTRAINT "pk_id_1" primary key (id)
);

create table sales_reps3(
    id NUMBER(6,0) primary key, -- works same as before.
    name varchar2(60), 
    salary NUMBER(8, 2), 
    commission number(2, 2) default 0.0
);
```

### alter primary key.
primary key can be `update`-d, but it has to be `unique`.
### foreign key.

### add column
```sql
alter table sales_reps3 
add dept_id number(6,0);
```

### on delete < foreign key.
`cascade` / `set null`  <<< ==This is given as HW==. create 2 table and set primary and foreign key, insert data. implement this constraint. check by deleting the foreign key (the `cascade` constraint). 
I can add this constraint when adding a foreign key.

### check constraint 
In this `check`  constraint,  `null` value doesn't trigger any violation. 