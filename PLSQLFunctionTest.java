package unit_testing;

import java.sql.*;

public class PLSQLFunctionTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Test calculate_discount function
            testDiscountFunction(conn, 1000, "GOLD", 200);
            testDiscountFunction(conn, 500, "SILVER", 50);
            testDiscountFunction(conn, 300, "REGULAR", 15);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void testDiscountFunction(Connection conn, double amount, 
                                           String customerType, double expected) throws SQLException {
        String sql = "{ ? = call calculate_discount(?, ?) }";
        
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.registerOutParameter(1, Types.DOUBLE);
            stmt.setDouble(2, amount);
            stmt.setString(3, customerType);
            stmt.execute();
            
            double result = stmt.getDouble(1);
            
            if (Math.abs(result - expected) < 0.01) {
                System.out.printf("PASS: calculate_discount(%.2f, %s) = %.2f%n", 
                                 amount, customerType, result);
            } else {
                System.out.printf("FAIL: calculate_discount(%.2f, %s) expected %.2f but got %.2f%n", 
                                 amount, customerType, expected, result);
            }
        }
    }
}