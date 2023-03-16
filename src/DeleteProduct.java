import java.sql.*;
import java.util.Scanner;

public class DeleteProduct {
    public DeleteProduct() {
        String url = "jdbc:mysql://localhost:3306/task";
        String uname = "root";
        String pass = "262000";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the product id to delete: ");
        int id = sc.nextInt();
        String query = "DELETE FROM product WHERE product_id="+id+";";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            Statement st = con.createStatement();
            st.executeUpdate(query);

            System.out.println("Product details deleted");

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

    }
}
