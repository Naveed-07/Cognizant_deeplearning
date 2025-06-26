CREATE OR REPLACE FUNCTION get_employee_service_years(
    emp_id IN NUMBER
) RETURN NUMBER AS
    hire_date DATE;
    service_years NUMBER;
BEGIN
    SELECT hire_date INTO hire_date 
    FROM employees 
    WHERE employee_id = emp_id;
    
    service_years := FLOOR(MONTHS_BETWEEN(SYSDATE, hire_date)/12);
    RETURN service_years;
END get_employee_service_years;
/

DECLARE
    years_of_service NUMBER;
BEGIN
    years_of_service := get_employee_service_years(200);
    DBMS_OUTPUT.PUT_LINE('Employee has ' || years_of_service || ' years of service');
END;
/