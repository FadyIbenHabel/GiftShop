package giftshop;
import java.util.List;


class User {
    protected String userId;
    protected String username;
    protected String password;
    protected String role;


    public User(String userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public boolean authenticate(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    public void displayInventory(InventoryManager inventoryManager) {
        inventoryManager.displayAllProducts();
    }


    public void getProductInfo(InventoryManager inventoryManager, String productName) {
        List<Product> productList = inventoryManager.getProductList();

        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("Product Information for " + productName + ":");
                product.displayProductInfo();
                return;
            }
        }

        System.out.println("Product not found in inventory.");
    }

}

