
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Add product");
        System.out.println("2) Update product");
        System.out.println("3) Show products");
        System.out.println("4) Delete product");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        do {
            switch (choice) {
                case 1:
                    AddProduct add = new AddProduct();
                    break;
                case 2:
                        UpdateProduct update = new UpdateProduct();
                    break;
                case 3:
                    RetrieveProduct show = new RetrieveProduct();
                    break;

                case 4:
                    DeleteProduct delete = new DeleteProduct();
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        while (false);
    }
}