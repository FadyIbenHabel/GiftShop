package giftshop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class InventoryManager {
    private static List<Product> productList;

    public InventoryManager() {
        this.productList = new ArrayList<>();
    }

    public void updateProductQuantities(Map<String, Integer[]> productQuantities) {
        for (Product product : productList) {
            String productName = product.getProductName();
            Integer[] quantities = productQuantities.get(productName);

            if (quantities != null) {
                int totalQuantityPurchased = quantities[0];
                int totalQuantitySold = quantities[1];

                int newQuantityInStock = product.getQuantityInStock() + totalQuantityPurchased - totalQuantitySold;
                product.setQuantityInStock(newQuantityInStock);
            }
        }
    }

    public void addProduct(Product newProduct) {
        productList.add(newProduct);
    }

    public void displayAllProducts() {
        System.out.println("Inventory Products:");
        for (Product product : productList) {
            System.out.println("Product Name: " + product.getProductName() +
                    ", Quantity in Stock: " + product.getQuantityInStock() +
                    ", Price: " + product.getPrice() +
                    ", Cost: " + product.getCost() +
                    ", Category: " + product.getCategory());
        }
    }

    // Getter method for obtaining the product list
    public static List<Product> getProductList() {
        return productList;
    }
   
}