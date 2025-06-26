package unit_testing;

import java.sql.*;

public class PLSQLPackageTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Test employee package functions
            testEmployeePackage(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void testEmployeePackage(Connection conn) throws SQLException {
        testFunction(conn, 
                   "{ ? = call employee_pkg.get_employee_salary(?) }", 
                   100, 24000.00);
        
        testUpdateSalaryProcedure(conn, 101, 10); // 10% raise
        
        testRefCursorFunction(conn);
    }
    
    private static void testFunction(Connection conn, String sql, 
                                   int input, double expected) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.registerOutParameter(1, Types.DOUBLE);
            stmt.setInt(2, input);
            stmt.execute();
            
            double result = stmt.getDouble(1);
            
            if (Math.abs(result - expected) < 0.01) {
                System.out.printf("PASS: Function returned %.2f as expected%n", result);
            } else {
                System.out.printf("FAIL: Expected %.2f but got %.2f%n", expected, result);
            }
        }
    }
    
    private static void testUpdateSalaryProcedure(Connection conn, 
                                               int empId, double percent) throws SQLException {
        // Get current salary first
        double oldSalary = getEmployeeSalary(conn, empId);
        
        String sql = "{ call employee_pkg.update_employee_salary(?, ?) }";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, empId);
            stmt.setDouble(2, percent);
            stmt.execute();
            
            double newSalary = getEmployeeSalary(conn, empId);
            double expected = oldSalary * (1 + percent/100);
            
            if (Math.abs(newSalary - expected) < 0.01) {
                System.out.printf("PASS: Salary updated from %.2f to %.2f (%.1f%% increase)%n", 
                                oldSalary, newSalary, percent);
            } else {
                System.out.printf("FAIL: Expected %.2f but got %.2f%n", expected, newSalary);
            }
        }
    }
    
    private static double getEmployeeSalary(Connection conn, int empId) throws SQLException {
        String sql = "SELECT salary FROM employees WHERE employee_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        }
        return 0;
    }
    
    private static void testRefCursorFunction(Connection conn) throws SQLException {
        String sql = "{ ? = call employee_pkg.get_department_employees(?) }";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.registerOutParameter(1, Types.REF_CURSOR);
            stmt.setInt(2, 50); // Department ID
            stmt.execute();
            
            try (ResultSet rs = (ResultSet)stmt.getObject(1)) {
                System.out.println("Employees in Department 50:");
                System.out.println("ID\tName\t\tSalary");
                System.out.println("--------------------------------");
                
                int count = 0;
                while (rs.next()) {
                    System.out.printf("%d\t%s %s\t%.2f%n",
                                    rs.getInt("employee_id"),
                                    rs.getString("first_name"),
                                    rs.getString("last_name"),
                                    rs.getDouble("salary"));
                    count++;
                }
                
                if (count > 0) {
                    System.out.printf("PASS: Retrieved %d employees%n", count);
                } else {
                    System.out.println("FAIL: No employees returned");
                }
            }
        }
    }
}