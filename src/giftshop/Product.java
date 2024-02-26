package giftshop;
import java.util.Objects;
public class Product{

    private int productId;
    private String productName;
    private int quantityInStock;
    private double price;
    private double cost;
    private String category;


    public Product(int productId, String productName, int quantityInStock, double price,double cost, String category) {
        this.productId = productId;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.cost = cost;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }
    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public void updateQuantity(int newQuantity) {
        this.quantityInStock = newQuantity;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.println("Price: $" + price);
        System.out.println("Cost : $" + cost);
        System.out.println("Category: " + category);
    }
    public static String getProductNameById(int productId) {

        for (Product product : InventoryManager.getProductList()) {
            if (product.getProductId() == productId) {
                return product.getProductName();
            }
        }
        return null; 
    }

    // Equals and hashCode methods for comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
       
}


