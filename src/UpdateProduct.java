import java.sql.*;
import java.util.Scanner;

public class UpdateProduct {
    public UpdateProduct() throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the product id to update: ");
        int id = sc.nextInt();
        System.out.println("Select column name to update");
        System.out.println("1) Product name");
        System.out.println("2) Category id");
        System.out.println("3) Tax");
        System.out.println("4) MRP");
        int choice = sc.nextInt();

        Connection conn = Connect.getConnection();
        Statement st = conn.createStatement();

        do {
            switch (choice) {

                case 1:
                    System.out.print("Enter new product name: ");
                    String name = sc.next();
                    String query = "update product set name ='"+name+"' where product_id="+id+";";
                    st.executeUpdate(query);
                    System.out.println("Product details Updated");
                    break;

                case 2:
                    System.out.print("Enter category id: ");
                    int cat_id = sc.nextInt();
                    String query1 = "update product set category_id ="+cat_id+" where product_id="+id+";";
                    st.executeUpdate(query1);
                    System.out.println("Product details Updated");
                    break;

                case 3:
                    System.out.print("Enter new tax of the product: ");
                    int tax = sc.nextInt();
                    String query2 = "update product set tax ="+tax+" where product_id="+id+";";
                    String query4 = "select tax,mrp from product where product_id="+id+";";
                    ResultSet rs = st.executeQuery(query4);
                    rs.next();
                    int old_tax = rs.getInt("tax");
                    int old_mrp = rs.getInt("mrp");
                    st.executeUpdate(query2);
                    int new_mrp=old_mrp+tax-old_tax;
                    String query5 = "update product set mrp ="+new_mrp+" where product_id="+id+";";
                    st.executeUpdate(query5);
                    System.out.println("Product details Updated");
                    break;

                case 4:
                    System.out.print("Enter new MRP: ");
                    int mrp = sc.nextInt();
                    String query3 = "update product set mrp ="+mrp+" where product_id="+id+";";
                    st.executeUpdate(query3);
                    System.out.println("Product details Updated");
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        while (false);
        st.close();
        conn.close();
    }


}
