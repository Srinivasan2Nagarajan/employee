SELECT * FROM departments
SELECT * FROM EMPLOYEES

 #Get employee by department 
SELECT * FROM EMPLOYEES INNER JOIN DEPARTMENTS ON EMPLOYEES.`DEPARTMENT_ID` = DEPARTMENTS.`DEPARTMENT_ID`

 #Number of employee worked on year 2014
SELECT COUNT(*) FROM EMPLOYEES INNER JOIN job_history ON EMPLOYEES.`EMPLOYEE_ID` = job_history.`EMPLOYEE_ID`
WHERE job_history.`START_DATE` BETWEEN "2014-01-01" AND "2014-12-31"

#Get employee by countries 
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, COUNTRY_NAME FROM EMPLOYEES 
INNER JOIN DEPARTMENTS ON EMPLOYEES.`DEPARTMENT_ID` = DEPARTMENTS.`DEPARTMENT_ID` 
INNER JOIN LOCATIONS ON DEPARTMENTS.`LOCATION_ID` = LOCATIONS.`LOCATION_ID`
INNER JOIN countries ON countries.`COUNTRY_ID` = LOCATIONS.`COUNTRY_ID`

 #Write a method get distinct employees by location ID.    eg: List<Employee> getEmployeeByLocationId(int locationId)
SELECT LOCATION_ID FROM LOCATIONS 
INNER JOIN (SELECT DEPARTMENT_NAME FROM DEPARTMENTS) ON LOCATIONS.`LOCATION_ID` = DEPARTMENTS.`LOCATION_ID`
INNER JOIN EMPLOYEES ON DEPARTMENTS.`DEPARTMENT_ID` = EMPLOYEES.`DEPARTMENT_ID`
 
SELECT * FROM LOCATIONS 
INNER JOIN DEPARTMENTS ON LOCATIONS.`LOCATION_ID` = DEPARTMENTS.`LOCATION_ID`
INNER JOIN EMPLOYEES ON DEPARTMENTS.`DEPARTMENT_ID` = EMPLOYEES.`DEPARTMENT_ID`

 #Write a method get employees by Job ID. 
 SELECT * FROM JOBS LEFT OUTER JOIN EMPLOYEES ON JOBS.`JOB_ID`= employees.`JOB_ID`;
 
 #job title, start date, departname, city ,country name, region name
SELECT FIRST_NAME, LAST_NAME, JOB_TITLE, START_DATE, DEPARTMENT_NAME, CITY, COUNTRY_NAME, REGION_NAME 
FROM EMPLOYEES LEFT OUTER JOIN JOBS ON employees.`JOB_ID` = JOBS.`JOB_ID`
LEFT OUTER JOIN job_history ON employees.`EMPLOYEE_ID` = job_history.`EMPLOYEE_ID`
LEFT OUTER JOIN DEPARTMENTS ON employees.`DEPARTMENT_ID` = DEPARTMENTS.`DEPARTMENT_ID`
INNER JOIN LOCATIONS ON DEPARTMENTS.`LOCATION_ID` = LOCATIONS.`LOCATION_ID`
INNER JOIN countries ON countries.`COUNTRY_ID` = LOCATIONS.`COUNTRY_ID`
INNER JOIN REGIONS ON countries.`REGION_ID` = REGIONS.`REGION_ID`






 