import java.sql.*;
import java.util.Scanner;

public class RetrieveProduct {
    public RetrieveProduct() {
        String url = "jdbc:mysql://localhost:3306/task";
        String uname = "root";
        String pass = "262000";

        String query = "select product_id,name,tax,mrp,category_type from product,product_category where product.category_id=product_category.category_id;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            String UserData = "";

            System.out.println("ProductId--"+"Product--"+"Tax--"+"Mrp--"+"CategoryName");
            while(rs.next())
            {
                UserData = rs.getInt(1)+ "-----" +rs.getString(2)+"-----"+rs.getInt(3)+"-----"+rs.getInt(4)+"-----"+rs.getString(5);
                System.out.println(UserData);
            }

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

    }
}

