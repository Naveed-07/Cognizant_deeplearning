DECLARE
    CURSOR high_salary_emps IS
        SELECT employee_id, first_name, last_name, salary
        FROM employees
        WHERE salary > 15000
        ORDER BY salary DESC;
    
    emp_rec high_salary_emps%ROWTYPE;
BEGIN
    OPEN high_salary_emps;
    
    DBMS_OUTPUT.PUT_LINE('Highly Compensated Employees:');
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    
    LOOP
        FETCH high_salary_emps INTO emp_rec;
        EXIT WHEN high_salary_emps%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(
            emp_rec.employee_id || ': ' || 
            emp_rec.first_name || ' ' || emp_rec.last_name || 
            ' earns $' || emp_rec.salary
        );
    END LOOP;
    
    CLOSE high_salary_emps;
END;
/