DECLARE
    dept_id NUMBER := 999;
    dept_name VARCHAR2(100);
BEGIN
    SELECT department_name INTO dept_name 
    FROM departments 
    WHERE department_id = dept_id;
    
    DBMS_OUTPUT.PUT_LINE('Department Name: ' || dept_name);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Department ID ' || dept_id || ' does not exist');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Multiple departments found for ID ' || dept_id);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/