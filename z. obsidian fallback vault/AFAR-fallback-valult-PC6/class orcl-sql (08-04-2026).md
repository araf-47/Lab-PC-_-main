`Book`: workshop 2, volume 1.
***
### view
- what is it?
- There is a difference between view and table.

#### Create view
```sql
create view yearly_salary as
(select first_name, salary * 12 yearly_sal from employees);
```
↪you can also `replace` view if view already exist. or you can say `create or replace`.

```sql
CREATE OR REPLACE VIEW empvu20 CREATE OR REPLACE VIEW empvu20
AS SELECT *
FROM employees
WHERE department_id = 20
```
#### Denying DML 
`with read only`
#### drop view
```sql
drop view yearly_salary;
```

# Ch. 5
### add constraint

### dropping constraint

# extras:
- access control 
	- grant. 
	- revoke.