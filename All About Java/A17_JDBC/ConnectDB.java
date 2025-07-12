// ConnectDB.java
import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Change your_db_name
        String user = "root";  // Replace with your MySQL username
        String password = "Khushal@546";  // Replace with your password

        try {
            // Load the JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            
            Statement stmt = conn.createStatement();
            /*
            String sql = "INSERT into student values(3,'khushal')";
            int rowAffected = stmt.executeUpdate(sql);
            if(rowAffected > 0 ){
                System.out.println("Inserted success");
            }else{
                System.out.println("Inserted failed!");
            }*/
            String query = "Select * from student";
            ResultSet rs = stmt.executeQuery(query);//data sara rs me store
                System.out.println("ID"+"  "+"Name");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id+"  "+name);
            }

            conn.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Connection failed:");
            e.printStackTrace();
        }
    }
}

/*
cd "E:\MCA\sem 2\JAVA\All About Java\A17_JDBC"
javac -cp ".;lib\mysql-connector-j-9.3.0.jar" ConnectDB.java
            If successful, this will create: ConnectDB.class

java -cp ".;lib\mysql-connector-j-9.3.0.jar" ConnectDB


 */
