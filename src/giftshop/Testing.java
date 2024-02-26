package giftshop;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        // Create instances of the Product class
        Product handmadeWatch = new Product(1, "Handmade Watch", 20, 49.99, 29.99, "Accessories");
        Product handmadeRing = new Product(2, "Handmade Ring", 30, 29.99, 15.99, "Jewelry");
        Product handmadeBracelet = new Product(3, "Handmade Bracelet", 25, 39.99, 24.99, "Jewelry");
        Product handmadeEarrings = new Product(4, "Handmade Earrings", 35, 24.99, 13.99, "Accessories");
        Product handmadeKeyholder = new Product(5, "Handmade Keyholder", 40, 14.99, 5.99, "Accessories");

        // Initialize inventory manager and add products to the inventory
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(handmadeWatch);
        inventoryManager.addProduct(handmadeRing);
        inventoryManager.addProduct(handmadeBracelet);
        inventoryManager.addProduct(handmadeEarrings);
        inventoryManager.addProduct(handmadeKeyholder);
        
        // Read transactions from a file using FileHandler
        List<String> transactions = FileHandler.readTransactionsFromFile("transactions.txt");

        // Calculate total quantities from transactions using FileHandler
        Map<String, Integer[]> productQuantities = FileHandler.calculateTotalQuantities(transactions);

        // Update product quantities in the InventoryManager
        inventoryManager.updateProductQuantities(productQuantities);

        // Creating a list of users
        List<User> users = new ArrayList<>();
        Manager manager = new Manager("1", "manager1", "password123");
        Employee employee = new Employee("2", "employee1", "password456");
        users.add(manager);
        users.add(employee);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();


        User loggedInUser = null;
        for (User user : users) {
            if (user.getUsername().equals(enteredUsername) && user.authenticate(enteredPassword)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println(loggedInUser.getUsername() + " login successful.");

            if (loggedInUser instanceof Manager) {
                displayManagerUI(loggedInUser, inventoryManager,transactions);
            } else  {
            	displayEmployeeUI(loggedInUser, inventoryManager);

            }
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }
    //
    private static void displayManagerUI(User user, InventoryManager inventoryManager, List<String> transactions) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Manager Options:");
            System.out.println("1. Display Inventory");
            System.out.println("2. Get Product Information");
            System.out.println("3. Generate Sales Report");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    user.displayInventory(inventoryManager);
                    break;
                case 2:
                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();
                    user.getProductInfo(inventoryManager, productName);
                    break;
                case 3:
                    ((Manager) user).generateSalesReport(new SalesReportGenerator(inventoryManager.getProductList(),transactions));
                    break;
                case 4:
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
    private static void displayEmployeeUI(User user, InventoryManager inventoryManager) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Options:");
            System.out.println("1. Display Inventory");
            System.out.println("2. Get Product Information");
            System.out.println("3. Add Transaction");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    user.displayInventory(inventoryManager);
                    break;
                case 2:
                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();
                    user.getProductInfo(inventoryManager, productName);
                    break;
                case 3:
                	((Employee) user).addTransaction();
                	break;
                case 4:
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}



