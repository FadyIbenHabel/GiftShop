package giftshop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {

    public static List<String> readTransactionsFromFile(String filePath) {
        List<String> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    public static Map<String, Integer[]> calculateTotalQuantities(List<String> transactions) {
        Map<String, Integer[]> productQuantities = new HashMap<>();

        for (String transaction : transactions) {
            String[] parts = transaction.split(", ");
            if (parts.length == 3) {
                String productName = parts[0].split(":")[1].trim();
                int quantity = Integer.parseInt(parts[1].split(":")[1].trim());
                String transactionType = parts[0].substring(0, parts[0].indexOf(":")).trim();
        
                if (transactionType.equals("Purchase") || transactionType.equals("Sale")) {
                    Integer[] quantities = productQuantities.getOrDefault(productName, new Integer[]{0, 0});
                    if (transactionType.equals("Purchase")) {
                        quantities[0] += quantity; 
                    } else {
                        quantities[1] += quantity; 
                    }
                    productQuantities.put(productName, quantities);
                }
            }
        }

        return productQuantities;
    }
    public static void writeTransactionToFile(String transaction) {
        String filename = "transactions.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        	writer.newLine();
        	writer.write(transaction);
            System.out.println("Transaction recorded in " + filename);
        } catch (IOException e) {
            System.err.println("Error writing transaction to file: " + e.getMessage());
        }
    }
}