DECLARE
    employee_name VARCHAR2(100) := 'Sarah Johnson';
    base_salary NUMBER := 75000;
    performance_bonus NUMBER;
    total_compensation NUMBER;
BEGIN
    performance_bonus := base_salary * 0.20;
    total_compensation := base_salary + performance_bonus;
    
    DBMS_OUTPUT.PUT_LINE('Employee: ' || employee_name);
    DBMS_OUTPUT.PUT_LINE('Base Salary: $' || base_salary);
    DBMS_OUTPUT.PUT_LINE('Performance Bonus: $' || performance_bonus);
    DBMS_OUTPUT.PUT_LINE('Total Annual Compensation: $' || total_compensation);
END;
/