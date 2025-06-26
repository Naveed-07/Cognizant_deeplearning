package unit_testing;

import java.sql.*;

public class PLSQLProcedureTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Setup test data
            setupTestData(conn);
            
            // Test update_inventory procedure
            testInventoryUpdate(conn, 101, 5, true);  // Should pass
            testInventoryUpdate(conn, 101, 20, false); // Should fail
            
            // Cleanup
            cleanupTestData(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void setupTestData(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO products (product_id, product_name, stock_quantity) " +
                         "VALUES (101, 'Test Product', 10)");
            conn.commit();
        }
    }
    
    private static void testInventoryUpdate(Connection conn, int productId, 
                                         int quantity, boolean shouldPass) throws SQLException {
        String sql = "{ call update_inventory(?, ?) }";
        
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, productId);
            stmt.setInt(2, quantity);
            
            try {
                stmt.execute();
                if (shouldPass) {
                    System.out.printf("PASS: update_inventory(%d, %d) succeeded as expected%n", 
                                    productId, quantity);
                    
                    // Verify the update
                    try (Statement verifyStmt = conn.createStatement();
                         ResultSet rs = verifyStmt.executeQuery(
                             "SELECT stock_quantity FROM products WHERE product_id = " + productId)) {
                        if (rs.next()) {
                            int newQuantity = rs.getInt(1);
                            System.out.printf("  New quantity: %d%n", newQuantity);
                        }
                    }
                } else {
                    System.out.printf("FAIL: update_inventory(%d, %d) should have failed but succeeded%n", 
                                     productId, quantity);
                }
            } catch (SQLException e) {
                if (shouldPass) {
                    System.out.printf("FAIL: update_inventory(%d, %d) failed unexpectedly: %s%n", 
                                    productId, quantity, e.getMessage());
                } else {
                    System.out.printf("PASS: update_inventory(%d, %d) failed as expected: %s%n", 
                                    productId, quantity, e.getMessage());
                }
            }
        }
    }
    
    private static void cleanupTestData(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM products WHERE product_id = 101");
            conn.commit();
        }
    }
}