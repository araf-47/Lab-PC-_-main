

```sql
-- STEP 1: REGIONS (Parent of Countries)
CREATE TABLE regions (
    region_id      NUMBER PRIMARY KEY,
    region_name    VARCHAR2(25)
);

-- STEP 2: COUNTRIES (Parent of Locations)
CREATE TABLE countries (
    country_id      CHAR(2) PRIMARY KEY,
    country_name    VARCHAR2(40),
    region_id       NUMBER,
    CONSTRAINT countr_reg_fk FOREIGN KEY (region_id) REFERENCES regions(region_id)
);

-- STEP 3: LOCATIONS (Parent of Departments)
CREATE TABLE locations (
    location_id     NUMBER(4) PRIMARY KEY,
    street_address  VARCHAR2(40),
    postal_code     VARCHAR2(12),
    city            VARCHAR2(30) NOT NULL,
    state_province  VARCHAR2(25),
    country_id      CHAR(2),
    CONSTRAINT loc_c_id_fk FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

-- STEP 4: DEPARTMENTS (Parent of Employees)
CREATE TABLE departments (
    department_id   NUMBER(4) PRIMARY KEY,
    department_name VARCHAR2(30) NOT NULL,
    manager_id      NUMBER(6),
    location_id     NUMBER(4),
    CONSTRAINT dept_loc_fk FOREIGN KEY (location_id) REFERENCES locations(location_id)
);

-- STEP 5: JOBS (Parent of Employees)
CREATE TABLE jobs (
    job_id         VARCHAR2(10) PRIMARY KEY,
    job_title      VARCHAR2(35) NOT NULL,
    min_salary     NUMBER(6),
    max_salary     NUMBER(6)
);

-- STEP 6: EMPLOYEES
CREATE TABLE employees (
    employee_id    NUMBER(6) PRIMARY KEY,
    first_name     VARCHAR2(20),
    last_name      VARCHAR2(25) NOT NULL,
    email          VARCHAR2(25) NOT NULL,
    phone_number   VARCHAR2(20),
    hire_date      DATE NOT NULL,
    job_id         VARCHAR2(10) NOT NULL,
    salary         NUMBER(8,2),
    commission_pct NUMBER(2,2),
    manager_id     NUMBER(6),
    department_id  NUMBER(4),
    CONSTRAINT emp_dept_fk FOREIGN KEY (department_id) REFERENCES departments(department_id),
    CONSTRAINT emp_job_fk FOREIGN KEY (job_id) REFERENCES jobs(job_id)
);

-- STEP 7: INSERT DATA
INSERT INTO regions VALUES (1, 'Europe');
INSERT INTO regions VALUES (2, 'Americas');
INSERT INTO regions VALUES (3, 'Asia');
INSERT INTO regions VALUES (4, 'Middle East and Africa');

INSERT INTO countries VALUES ('IT', 'Italy', 1);
INSERT INTO countries VALUES ('JP', 'Japan', 3);
INSERT INTO countries VALUES ('US', 'United States of America', 2);
INSERT INTO countries VALUES ('BD', 'Bangladesh', 3);

INSERT INTO locations VALUES (1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US');
INSERT INTO locations VALUES (1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA');

INSERT INTO jobs VALUES ('AD_PRES', 'President', 20000, 40000);
INSERT INTO jobs VALUES ('IT_PROG', 'Programmer', 4000, 10000);

INSERT INTO departments VALUES (90, 'Executive', NULL, 1700);
INSERT INTO departments VALUES (60, 'IT', NULL, 1700);

INSERT INTO employees VALUES (100, 'Steven', 'King', 'SKING', '515.123.4567', TO_DATE('17-06-2003', 'DD-MM-YYYY'), 'AD_PRES', 24000, NULL, NULL, 90);
INSERT INTO employees VALUES (103, 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', TO_DATE('03-01-2006', 'DD-MM-YYYY'), 'IT_PROG', 9000, NULL, 100, 60);

COMMIT;
```