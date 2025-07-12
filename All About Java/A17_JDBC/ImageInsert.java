/*sql command
create databases;
use testdb;
mysql> desc ImageInsert;
+-------------+-----------+------+-----+-------------------+-------------------+
| Field       | Type      | Null | Key | Default           | Extra             |
+-------------+-----------+------+-----+-------------------+-------------------+
| image_id    | int       | NO   | PRI | NULL              | auto_increment    |
| image_data  | longblob  | NO   |     | NULL              |                   |
| upload_date | timestamp | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+-------------+-----------+------+-----+-------------------+-------------------+

 */

import java.sql.*;
import java.util.*;
import java.io.*;
public class ImageInsert{
        private static final String url="jdbc:mysql://localhost:3306/testdb";
        private static final String user = "root";
        private static final String password="Khushal@546";
    public static void main(String[] args){
        String image_path = "C:\\Users\\Shravan\\Desktop\\image for site\\equipment\\ee52.png";
        String folder_path = "E:\\MCA\\sem 2\\JAVA\\All About Java\\A17_JDBC\\Folder store image\\";
        String query = "Select image_data from ImageInsert where image_id =(?)";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Successfully");
            /*
            //convert image jpg to binary formate
            FileInputStream fileInputStream = new FileInputStream(image_path);
            //java me store kre image ->byte ka Array bna le
            byte[] imageData = new byte[fileInputStream.available()];
            //available ke liye exception handle kr le catch me runtime

            fileInputStream.read(imageData);

            
            //Store in database
            String query = "Insert into ImageInsert(image_data) VALUES(?)";

            //? mark use kre or prepareStatement se value column no ke sath
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setBytes(1,imageData);//setString,setInt..

            int affectedRow = pstmt.executeUpdate();
            if(affectedRow>0){
                System.out.println("Insertion Successfully");
            }else{
                System.out.println("Insrtertion Failed!");
            }




             pstmt.close();
            fileInputStream.close();
            conn.close();
            */


            //ydi database se img folder me store krna 
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,1);//place 1 me id 1 select image_data from InageInsert where image id=(1)
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                byte[] image_data = rs.getBytes("image_data");
                String imagePath = folder_path+"extractedImage.jpg";
                OutputStream os = new FileOutputStream(imagePath);
                os.write(image_data);
                System.out.println("Image successfully into folder !");
            
            }else{
                System.out.println("Image not found!");
            }

        
            pstmt.close();
            rs.close();
            conn.close();
        
        } catch (FileNotFoundException e) {
            System.err.println("Image file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading image file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

/*
javac -cp ".;lib\mysql-connector-j-9.3.0.jar" ImageInsert.java

java -cp ".;lib\mysql-connector-j-9.3.0.jar" ImageInsert

 */