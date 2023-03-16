import java.util.Scanner;
import java.sql.*;
public class AddProduct {
    public AddProduct() {
        String url = "jdbc:mysql://localhost:3306/task";
        String uname = "root";
        String pass = "262000";

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the following details");
        System.out.print("Product id : ");
        int product_id = sc.nextInt();
        System.out.print("Product name : ");
        String product_name = sc.next();
        System.out.print("Category id : ");
        int category_id = sc.nextInt();
        System.out.print("Tax : ");
        int tax = sc.nextInt();
        System.out.print("MRP : ");
        int mrp = sc.nextInt();


        String query = "insert into product values (?,?,?,?,?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,product_id);
            st.setString(2,product_name);
            st.setInt(3,category_id);
            st.setInt(4,tax);
            st.setInt(5,mrp);
            int count = st.executeUpdate();//use when update table

            System.out.println(count + " row/s affected");
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex) {
            System.out.println("Error!!!!!");
            System.exit(1);
        }

    }
}
