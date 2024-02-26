package giftshop;
import java.util.List;

public class SalesReportGenerator {
    private List<Product> productList;
    private List<String> salesTransactions;


    public SalesReportGenerator(List<Product> productList, List<String> salesTransactions) {
        this.productList = productList;
        this.salesTransactions = salesTransactions;
    }

 // Method to generate sales reports
    public void generateSalesReport() {
        double totalRevenue = 0;
        double totalCost = 0;

        // Track product sales quantities
        int[] productSales = new int[productList.size()];

        // Process sales transactions
        for (String transaction : salesTransactions) {
            String[] parts = transaction.split(", ");

            // Check if the array has enough elements
            if (parts.length == 3) {
                String productName = parts[0].split(":")[1].trim();
                int quantity = Integer.parseInt(parts[1].split(":")[1].trim());

                // Update product sales quantities
                updateProductSales(productName, quantity, productSales);

                // Update revenue and cost based on product price
                for (Product product : productList) {
                    if (product.getProductName().equals(productName)) {
                        totalRevenue += quantity * product.getPrice();
                        totalCost += quantity * product.getCost();
                        break;
                    }
                }
            }
        }
        // Calculate profit
        double totalProfit = totalRevenue - totalCost;

        // Identify best-selling product
        int bestSellerIndex = findBestSeller(productSales);

        // Display the generated report
        System.out.println("Sales Report:");
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Total Profit: $" + totalProfit);
        System.out.println("Best Selling Product: " + productList.get(bestSellerIndex).getProductName());
    }

    // Method to update product sales quantities
    private void updateProductSales(String productName, int quantity, int[] productSales) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(productName)) {
                productSales[i] += quantity;
                break;
            }
        }
    }

    // Method to find the index of the best-selling product
    private int findBestSeller(int[] productSales) {
        int maxSales = 0;
        int bestSellerIndex = 0;

        for (int i = 0; i < productSales.length; i++) {
            if (productSales[i] > maxSales) {
                maxSales = productSales[i];
                bestSellerIndex = i+1;
            }
        }

        return bestSellerIndex;
    }
}