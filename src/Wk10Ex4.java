//Import ArrayList utility.
import java.util.ArrayList;
//Import Scanner utility for user input.
import java.util.Scanner;

public class Wk10Ex4 
{
    //Product class.
    public static class Product
    {   
        //Declare product attributes
        public String ProductID;
        public String ProductName;
        public Double Price;
        //Constructor to initialize product attributes
        public Product(String ProductID, String ProductName, Double Price)
        {
            this.ProductID = ProductID;
            this.ProductName = ProductName;
            this.Price = Price;
        }
    }
    //ShoppingCart class to manage cart actions.
    public static class ShoppingCart
    {
        //List to store added products.
        ArrayList<Product> Cart = new ArrayList<>();
        
        //Method to add product to cart
        public void AddProduct(Product product)
        {
            //Add product object to the list
            Cart.add(product); 
            //Styling.
            System.out.println("=========================");
            System.out.println("Product " + product.ProductName + " Added to Cart!");
            //Styling.
            System.out.println("=========================");
        }
        //Method to remove a product from the cart using its ID
        public void RemoveProduct(String ProductID)
        {
            //Flag to track if a match was found.
            boolean removed = false; 
            //Loop through each product in the cart
            for (Product p : Cart)
            {
                //Check if product ID matches existent.
                if (p.ProductID.equals(ProductID))
                {
                    //Remove product from the cart
                    Cart.remove(p); 
                    //Styling.
                    System.out.println("=========================");
                    System.out.println("Product " + p.ProductName + " Removed");
                    //Styling.
                    System.out.println("=========================");
                    //Set removed to true is action is performed.
                    removed = true;
                    //Exit loop after removing
                    break; 
                }
            }
            //If no matching product was found
            if (!removed)
            {
                //Styling.
                System.out.println("=========================");
                //User Message.
                System.out.println("Product Not Found!");
                //Styling
                System.out.println("=========================");
            }
        }
        //Method to calculate and display total price of items in the cart.
        public void CalculateTotalPrice()
        {
            //Variable to store total
            double totalPrice = 0; 

            //Loop through each product and add its price to total
            for (Product p : Cart)
            {
                //Adds product prices to totalPrice
                totalPrice += p.Price;
            }
            //Styling.
            System.out.println("=========================");
            //Display the total price
            System.out.println("Total Price of Cart: $" + totalPrice);
            //Styling.
            System.out.println("=========================");
        }
    }
    public static void main(String[] args)
    {
        //Create Scanner for user input
        Scanner userInput = new Scanner(System.in);
        //Create instance of ShoppingCart
        ShoppingCart cart = new ShoppingCart();
        //Variable to store user's menu selection
        int menuOption;
        //Show options until exit is selected,
        do 
        {
            //Display main menu
            System.out.println("=========================");
            System.out.println("ONLINE STORE SYSTEM");
            System.out.println("=========================");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Total Price");
            System.out.println("4. Exit");
            System.out.print("Enter Option: ");
            //Get user choice
            menuOption = userInput.nextInt(); 
            //Experienced an issue with case 1 Enter product iID prompt.
            userInput.nextLine(); 
            //Switch to handle menu options
            switch (menuOption)
            {
                //Add product option
                case 1:
                    //Prompt user.
                    System.out.print("Enter Product ID: ");
                    String ProductID = userInput.nextLine(); 
                    //Prompt user.
                    System.out.print("Enter Product Name: ");
                    //Read product name
                    String ProductName = userInput.nextLine(); 
                    //Prompt user.
                    System.out.print("Enter Product Price: ");
                    //Read price
                    double Price = userInput.nextDouble(); 
                    //Create (new)product object
                    Product product = new Product(ProductID, ProductName, Price);
                    //Add product to cart
                    cart.AddProduct(product); 
                break;             
                //Remove product option
                case 2:
                    System.out.print("Enter Product ID to Remove: ");
                    //Read ID to remove
                    String productToRemove = userInput.nextLine(); 
                    //Call remove method
                    cart.RemoveProduct(productToRemove); 
                break;
                //Calculate total price option
                case 3:
                    //Call total price method
                    cart.CalculateTotalPrice(); 
                break;
                //Exit option
                case 4:
                break;
                //Handle invalid input
                default:
                    System.out.println("=========================");
                    System.out.println("Invalid option. Try Again!");
                    System.out.println("=========================");
                break;
            }

        } while (menuOption != 4);

        //Close scanner after program ends
        userInput.close();

        //Pushed to GitHub Wk10Ex4 Repo.
    }   
}
