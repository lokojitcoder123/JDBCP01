import java.sql.*;

public class InsertUsingPreparedDemo {

    /*1. load the driver class
      2. Get connection from db
      3. create statement
      4. execute query
    * */
    public static void main(String[] args)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //load driver class

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd", "root", "lokojit456789");


            String query = "INSERT INTO student (id , stdName , age) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1,101);
            pstmt.setString(2,"ankit");
            pstmt.setInt(3,14);
            pstmt.executeUpdate();


            pstmt.setInt(1,105);
            pstmt.setString(2,"raj");
            pstmt.setInt(3,25);
            pstmt.executeUpdate();

            System.out.println("multiple row inserted");
        }
       catch (Exception e)
       {
           e.printStackTrace();
        }

    }
}