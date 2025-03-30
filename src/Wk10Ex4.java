import java.util.ArrayList;
import java.util.Scanner;

public class Wk10Ex4 
{
    public static class Product
    {   
        public String ProductID;
        public String ProductName;
        public Double Price;

        public Product(String ProductID, String ProductName, Double Price)
        {
            this.ProductID = ProductID;
            this.ProductName = ProductName;
            this.Price = Price;
        }
    }
    public static class ShoppingCart
    {
        ArrayList<Product> Cart = new ArrayList<>();
        
        public void AddProduct(Product product)
        {
            Cart.add(product);
            System.out.println("=========================");
            System.out.println("Product " + product.ProductName + " Added to Cart!");
            System.out.println("=========================");
        }

        public void RemoveProduct(String ProductID)
        {
            boolean removed = false;
            for (Product p : Cart)
            {
                if (p.ProductID.equals(ProductID))
                {
                    Cart.remove(p);
                    System.out.println("=========================");
                    System.out.println("Product " + p.ProductName + " Removed");
                    System.out.println("=========================");
                    removed = true;
                    break;
                }
            }
            if (!removed)
            {
                System.out.println("=========================");
                System.out.println("Product Not Found!");
                System.out.println("=========================");
            }
        }

        public  void CalculateTotalPrice()
        {
            double totalPrice = 0;

            for (Product p : Cart)
            {
                totalPrice += p.Price;
            }
            System.out.println("=========================");
            System.out.println("Total Price of Cart: $" + totalPrice);
            System.out.println("=========================");
        }
    }
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        int menuOption;

        do 
        {
            System.out.println("=========================");
            System.out.println("ONLINE STORE SYSTEM");
            System.out.println("=========================");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Total Price");
            System.out.println("4. Exit");
            System.out.print("Enter Option: ");
            menuOption = userInput.nextInt();
            userInput.nextLine();

            switch (menuOption)
            {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String ProductID = userInput.nextLine();
                    System.out.print("Enter Product Name: ");
                    String ProductName = userInput.nextLine();
                    System.out.print("Enter Product Price: ");
                    double Price = userInput.nextDouble();
                    Product product = new Product(ProductID, ProductName, Price);
                    cart.AddProduct(product);
                break;             
                case 2:
                    System.out.print("Enter Product ID to Remove: ");
                    String productToRemove = userInput.nextLine();
                    cart.RemoveProduct(productToRemove);
                break;
                case 3:
                    cart.CalculateTotalPrice();
                break;
                case 4:
                break;
                default:
                    System.out.println("=========================");
                    System.out.println("Invalid option. Try Again!");
                    System.out.println("=========================");
                break;
            }


        } while (menuOption != 4);
        
        userInput.close();
    }
    
}
