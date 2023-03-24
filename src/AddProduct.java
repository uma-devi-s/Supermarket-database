import java.sql.Connection;
import java.util.Scanner;
import java.sql.*;
public class AddProduct {
    public AddProduct() throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the following details");
        System.out.print("Product name : ");
        String product_name = sc.next();
        System.out.print("Category id : ");
        int category_id = sc.nextInt();
        System.out.print("Tax : ");
        int tax = sc.nextInt();
        System.out.print("MRP : ");
        int mrp = sc.nextInt();


        String query = "insert into product(name,category_id,tax,mrp) values (?,?,?,?);";

        Connection conn = Connect.getConnection();

        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1,product_name);
        st.setInt(2,category_id);
        st.setInt(3,tax);
        st.setInt(4,mrp);
        int count = st.executeUpdate();//use when update table

        System.out.println(count + " row/s affected");
        st.close();
        conn.close();



    }
}
