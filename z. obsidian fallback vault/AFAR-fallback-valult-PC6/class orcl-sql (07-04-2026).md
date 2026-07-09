### clone table

```sql
create table dept_clone as
select department_id, department_name
from departments;

create table dept_clone2 (dept_id, dept_name, man_id, loc_id) as
select * 
from departments;
```

### Alter table
```sql
create table sub_class (
    cid number(4), 
    subject varchar2(66), 
    teacher_name varchar2(50)
);
```
#### add column
```sql
alter table sub_class
add (teacher_id number(4)); --<< can add more column by comma (,).
```
#### modify column
```sql
alter table sub_class
modify (teacher_name varchar2(55));
```

### Drop column
```sql
alter table sub_class
add (bullshit varchar2(500));

alter table sub_class
drop (bullshit);   --<< this drops the bullshit
```

### unused


### read only
```sql
alter table sub_class read only;

INSERT INTO sub_class (cid, subject, teacher_name, teacher_id) VALUES (109, 'Modern World Literature', 'Isabella wife', 5009);

alter table sub_class read write;

INSERT INTO sub_class (cid, subject, teacher_name, teacher_id) VALUES (109, 'Modern World Literature', 'Isabella wife', 5009);
```

### drop table
```sql
drop table sub_class;
```
