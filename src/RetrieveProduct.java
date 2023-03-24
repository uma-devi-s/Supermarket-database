import java.sql.*;
import java.util.Scanner;

public class RetrieveProduct {
    public RetrieveProduct() throws Exception{

        String query = "select product_id,name,tax,mrp,category_type from product,product_category where product.category_id=product_category.category_id;";
        Connection conn = Connect.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        String UserData = "";

        System.out.println("ProductId--"+"Product--"+"Tax--"+"Mrp--"+"CategoryName");
        while(rs.next())
        {
            UserData = rs.getInt(1)+ "-----" +rs.getString(2)+"-----"+rs.getInt(3)+"-----"+rs.getInt(4)+"-----"+rs.getString(5);
            System.out.println(UserData);
        }

        st.close();
        conn.close();

    }
}

