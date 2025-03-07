# SQL Cheat Sheet

## 1. **Basic SQL Syntax**

### Select Data
```sql
SELECT column1, column2 FROM table_name;


SELECT * FROM table_name;


SELECT column1, column2 FROM table_name WHERE condition;


SELECT * FROM employees WHERE age > 30;


SELECT column1, column2 FROM table_name ORDER BY column1 ASC;


SELECT * FROM employees ORDER BY salary DESC;


CREATE TABLE table_name (
    column1 datatype constraint,
    column2 datatype constraint,
    column3 datatype constraint,
    ...
);


CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    department VARCHAR(50)
);


ALTER TABLE table_name ADD column_name datatype;


ALTER TABLE employees ADD salary DECIMAL(10, 2);


ALTER TABLE table_name MODIFY column_name new_datatype;


ALTER TABLE employees MODIFY salary DECIMAL(15, 2);


ALTER TABLE table_name DROP COLUMN column_name;


ALTER TABLE employees DROP COLUMN department;


DROP TABLE table_name;


DROP TABLE employees;


INSERT INTO table_name (column1, column2, column3) 
VALUES (value1, value2, value3);


INSERT INTO employees (id, name, age, department) 
VALUES (1, 'Alice', 28, 'HR');


UPDATE table_name 
SET column1 = value1, column2 = value2
WHERE condition;


UPDATE employees 
SET salary = 55000 
WHERE id = 1;


DELETE FROM table_name WHERE condition;


DELETE FROM employees WHERE id = 1;


SELECT column1, column2 FROM table_name WHERE column1 = value;


SELECT * FROM employees WHERE department = 'HR';


SELECT columns 
FROM table1
INNER JOIN table2 
ON table1.column = table2.column;


SELECT employees.name, departments.name 
FROM employees 
INNER JOIN departments 
ON employees.department_id = departments.id;


SELECT columns 
FROM table1
LEFT JOIN table2 
ON table1.column = table2.column;


SELECT employees.name, departments.name 
FROM employees 
LEFT JOIN departments 
ON employees.department_id = departments.id;


SELECT columns 
FROM table1
RIGHT JOIN table2 
ON table1.column = table2.column;


SELECT employees.name, departments.name 
FROM employees 
RIGHT JOIN departments 
ON employees.department_id = departments.id;


SELECT COUNT(column) FROM table_name;


SELECT COUNT(*) FROM employees;


SELECT SUM(column) FROM table_name;


SELECT SUM(salary) FROM employees;


SELECT AVG(column) FROM table_name;


SELECT AVG(age) FROM employees;


SELECT MAX(column), MIN(column) FROM table_name;


SELECT MAX(salary), MIN(salary) FROM employees;


SELECT column, COUNT(*) 
FROM table_name 
GROUP BY column;


SELECT department, COUNT(*) 
FROM employees 
GROUP BY department;


SELECT column, COUNT(*) 
FROM table_name 
GROUP BY column 
HAVING COUNT(*) > value;


SELECT department, COUNT(*) 
FROM employees 
GROUP BY department 
HAVING COUNT(*) > 5;


SELECT column1, 
       (SELECT column2 FROM table2 WHERE condition) AS subquery_result
FROM table1;


SELECT name, 
       (SELECT department FROM departments WHERE id = employees.department_id) AS department
FROM employees;


SELECT column1, column2 
FROM table1 
WHERE column1 = (SELECT column FROM table2 WHERE condition);


SELECT name 
FROM employees 
WHERE department_id = (SELECT id FROM departments WHERE name = 'HR');


CREATE INDEX index_name 
ON table_name (column_name);


CREATE INDEX idx_employees_name 
ON employees (name);


DROP INDEX index_name ON table_name;


DROP INDEX idx_employees_name ON employees;


BEGIN TRANSACTION;


COMMIT;


ROLLBACK;


CREATE VIEW view_name AS 
SELECT column1, column2 
FROM table_name 
WHERE condition;


CREATE VIEW employee_view AS 
SELECT name, department 
FROM employees 
WHERE age > 30;


DROP VIEW view_name;


DROP VIEW employee_view;


SQL Data Types
INT: Integer
VARCHAR(n): Variable length string
CHAR(n): Fixed length string
DATE: Date (yyyy-mm-dd)
DATETIME: Date and time
DECIMAL(p, s): Fixed-point numbers
FLOAT: Floating-point numbers
BOOLEAN: Boolean (TRUE/FALSE)


SELECT CONCAT(column1, column2) FROM table_name;


SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM employees;


SELECT LENGTH(column) FROM table_name;


SELECT LENGTH(name) FROM employees;


SELECT LOWER(column) FROM table_name;
SELECT UPPER(column) FROM table_name;


SELECT LOWER(name) FROM employees;


SELECT TRIM(column) FROM table_name;


SELECT TRIM(name) FROM employees;


SELECT CURRENT_DATE;


SELECT DATE_ADD(column, INTERVAL value unit) FROM table_name;


SELECT DATE_ADD(hire_date, INTERVAL 1 YEAR) FROM employees;


SELECT DATEDIFF(end_date, start_date) FROM table_name;


SELECT DATEDIFF(CURRENT_DATE, hire_date) FROM employees;





