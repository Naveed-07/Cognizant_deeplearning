DECLARE
    counter NUMBER := 1;
    today_day VARCHAR2(20);
BEGIN
    SELECT TO_CHAR(SYSDATE, 'DAY') INTO today_day FROM dual;
    
    DBMS_OUTPUT.PUT_LINE('Today is ' || today_day);
    
    IF today_day LIKE 'S%' THEN
        DBMS_OUTPUT.PUT_LINE('It''s the weekend!');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Weekday work schedule:');
        
        WHILE counter <= 8 LOOP
            DBMS_OUTPUT.PUT_LINE('Meeting ' || counter || ' at ' || (8+counter) || ':00');
            counter := counter + 1;
        END LOOP;
    END IF;
END;
/