package unit_testing;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class PLSQLJUnitTest {
    private static Connection conn;
    
    @BeforeAll
    public static void setup() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";
        conn = DriverManager.getConnection(url, username, password);
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE OR REPLACE PACKAGE test_pkg AS " +
                         "FUNCTION add_numbers(a NUMBER, b NUMBER) RETURN NUMBER; " +
                         "PROCEDURE divide_numbers(a NUMBER, b NUMBER, result OUT NUMBER); " +
                         "END test_pkg;");
            
            stmt.execute("CREATE OR REPLACE PACKAGE BODY test_pkg AS " +
                         "FUNCTION add_numbers(a NUMBER, b NUMBER) RETURN NUMBER IS " +
                         "BEGIN RETURN a + b; END; " +
                         "PROCEDURE divide_numbers(a NUMBER, b NUMBER, result OUT NUMBER) IS " +
                         "BEGIN result := a / b; EXCEPTION WHEN ZERO_DIVIDE THEN result := NULL; END; " +
                         "END test_pkg;");
        }
    }
    
    @AfterAll
    public static void teardown() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
    @Test
    public void testAddNumbersFunction() throws SQLException {
        String sql = "{ ? = call test_pkg.add_numbers(?, ?) }";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.registerOutParameter(1, Types.NUMERIC);
            stmt.setInt(2, 5);
            stmt.setInt(3, 7);
            stmt.execute();
            
            assertEquals(12, stmt.getInt(1), "5 + 7 should equal 12");
        }
    }
    
    @Test
    public void testDivideNumbersProcedure() throws SQLException {
        String sql = "{ call test_pkg.divide_numbers(?, ?, ?) }";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, 10);
            stmt.setInt(2, 2);
            stmt.registerOutParameter(3, Types.NUMERIC);
            stmt.execute();
            
            assertEquals(5.0, stmt.getDouble(3), "10 / 2 should equal 5");
        }
    }
    
    @Test
    public void testDivideByZero() throws SQLException {
        String sql = "{ call test_pkg.divide_numbers(?, ?, ?) }";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, 10);
            stmt.setInt(2, 0);
            stmt.registerOutParameter(3, Types.NUMERIC);
            stmt.execute();
            
            assertNull(stmt.getObject(3), "Division by zero should return NULL");
        }
    }
}