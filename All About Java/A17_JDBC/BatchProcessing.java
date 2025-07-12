/*
Batch processing in JDBC allows you to execute multiple SQL statements at once, reducing 
the number of database calls and improving performance.

 Why Use Batch Processing?
    Efficient for bulk insert/update/delete operations.
    Reduces network round-trips between Java app and database.
    Saves execution time.
 */
import java.sql.*;

public class BatchProcessing{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "Khushal@546";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successfully");

            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO employees (name,job_title,salary)Values('Khushal','Software Eng',99000)";
            String query2 = "INSERT INTO employees (name,job_title,salary)Values('Rakesh','MR',34000)";
            String query3 = "INSERT INTO employees (name,job_title,salary)Values('Ram','HR',40000)";

            stmt.addBatch(query);
            stmt.addBatch(query2);
            stmt.addBatch(query3);
            /*//ya
            String sql = "INSERT INTO employees (name,job_title,salary)Values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // First record
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Khushal");
            pstmt.setInt(3, 99000);
            pstmt.addBatch();

            // Second record
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Aman");
            pstmt.setInt(3, 34000);
            pstmt.addBatch();

            // Third record
            pstmt.setInt(1, 3);
            pstmt.setString(2, "Ravi");
            pstmt.setInt(3, 40000);
            pstmt.addBatch(); */

            int[] batchResult = stmt.executeBatch();
            conn.commit();
            System.out.println("Batch Excecuted Sucessfully!");
            System.out.println("Batch Result: "+batchResult.length);







        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
