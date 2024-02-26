package giftshop;
import java.util.Scanner;


class Employee extends User {


public Employee(String userId, String username, String password) {
   super(userId, username, password, "Employee");
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public void addTransaction() {
	        Scanner scanner = new Scanner(System.in);
	        String transactionType;
	        do {
	            System.out.print("Enter transaction type (Purchase/Sale): ");
	            transactionType = scanner.nextLine();

	            if (!transactionType.equals("Purchase") && !transactionType.equals("Sale")) {
	                System.out.println("Invalid transaction type. Please enter either 'Purchase' or 'Sale'.");
	            }

	        } while (!transactionType.equals("Purchase") && !transactionType.equals("Sale"));

	        System.out.print("Enter product id: ");
	        int ProductID = scanner.nextInt();
	        String productName;
	        productName=Product.getProductNameById(ProductID);
	        scanner.nextLine();
	        
	        System.out.print("Enter quantity: ");
	        int quantity = scanner.nextInt();
	        scanner.nextLine(); //consume the next line

	        System.out.print("Enter date (YYYY-MM-DD): ");
	        String date = scanner.nextLine();

	        String newtransaction = transactionType + ": " +
	                productName + ", Quantity: " +
	                quantity + ", Date: " +
	                date;
	        FileHandler.writeTransactionToFile(newtransaction);

	        System.out.println("Transaction added successfully.");
	    }
	}
