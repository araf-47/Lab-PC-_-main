```sql
SHOW PDBS;

ALTER  SESSION  SET  CONTAINER  =  orclpdb;

ALTER  PLUGGABLE  DATABASE open;

ALTER USER HR ACCOUNT UNLOCK;

ALTER USER HR IDENTIFIED BY HR;
```
↪This solves the `hr` login issue and password.