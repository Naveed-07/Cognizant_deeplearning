CREATE OR REPLACE PROCEDURE adjust_salary(
    emp_id IN NUMBER, 
    adjustment_amount IN NUMBER
) AS
    current_salary NUMBER;
BEGIN
    SELECT salary INTO current_salary 
    FROM employees 
    WHERE employee_id = emp_id;
    
    UPDATE employees 
    SET salary = salary + adjustment_amount 
    WHERE employee_id = emp_id;
    
    DBMS_OUTPUT.PUT_LINE(
        'Adjusted salary for employee ' || emp_id || 
        ' from ' || current_salary || 
        ' to ' || (current_salary + adjustment_amount)
    );
    
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END adjust_salary;
/

BEGIN
    adjust_salary(101, 5000);
END;
/