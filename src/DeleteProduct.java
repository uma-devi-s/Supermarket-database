import java.sql.*;
import java.util.Scanner;

public class DeleteProduct {
    public DeleteProduct() throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the product id to delete: ");
        int id = sc.nextInt();
        String query = "DELETE FROM product WHERE product_id="+id+";";

        Connection conn = Connect.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(query);

        System.out.println("Product details deleted");

        st.close();
        conn.close();

    }
}
