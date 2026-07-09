```sql
select job_id, avg(salary)
from employees
group by job_id
having avg(salary) 
= 
(select min(avg(salary))
from employees group by job_id);
```

