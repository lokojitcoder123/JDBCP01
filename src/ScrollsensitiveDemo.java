import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollsensitiveDemo {

    /*1. load the driver class
      2. Get connection from db
      3. create statement
      4. execute query
    * */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //load driver class

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd", "root", "lokojit456789");

            Statement statement = con.

                    createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
            String query = "select * from student ";

            ResultSet rs = statement.executeQuery(query);

            System.out.println("fetch data is not live update mode........");
            Thread.sleep(10000);
            rs.beforeFirst();

            while(rs.next())
            {
                System.out.println(
                        rs.getInt("id")+ " | "+
                                rs.getString("stdName")+" | "+
                                rs.getInt("age")
                );
            }

            con.close();

            rs.last();
            System.out.println("Last Row: " + rs.getInt("id"));
            System.out.println("Last Row: " + rs.getString("stdName"));


            rs.first();
            System.out.println("Last Row: " + rs.getInt("id"));
            System.out.println("Last Row: " + rs.getString("stdName"));


            rs.absolute(2);
            System.out.println("Last Row: " + rs.getInt("id"));
            System.out.println("Last Row: " + rs.getString("stdName"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}