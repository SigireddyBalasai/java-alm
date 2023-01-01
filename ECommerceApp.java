import Bank.Accounts;
import Buyer.BuyerAccount;
import Seller.CartItem;
import Seller.Product;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ECommerceApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the e-commerce app!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter your desired username: ");
                String username = scanner.next();
                System.out.print("Enter your desired password: ");
                String password = scanner.next();

                BuyerAccount BuyerAccount = new BuyerAccount(username, password);
                BuyerAccount.account = new Accounts(username, password);
                BuyerAccount.account.commit();

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Buyer\\Accounts.txt", true))) {
                    writer.write(BuyerAccount.getUsername() + "," + password + ","
                            + BuyerAccount.account.getBalance() + "\n");
                    System.out.println("User account created successfully!");
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Enter your username: ");
                username = scanner.next();
                System.out.print("Enter your password: ");
                password = scanner.next();
                boolean loginSuccessful = false;
                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Buyer\\Accounts.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, ",");
                        String userId = tokenizer.nextToken();
                        String pass = tokenizer.nextToken();
                        if (userId.equals(username) && pass.equals(password)) {
                            loginSuccessful = true;
                            break;
                        }
                    }

                } catch (Exception e) {
                    e.getStackTrace();
                }

                if (loginSuccessful) {
                    System.out.println("Login successful!");

                    System.out.println("1. Create a new account");
                    System.out.println("2. Purchase");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter your desired username: ");
                            username = scanner.next();
                            System.out.print("Enter your desired password: ");
                            password = scanner.next();

                            BuyerAccount = new BuyerAccount(username, password);
                            BuyerAccount.account = new Accounts(username, password);

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Buyer\\Accounts.txt", true))) {
                                writer.write(BuyerAccount.getUsername() + "," + password + ","
                                        + BuyerAccount + "\n");
                                System.out.println("User account created successfully!");
                            } catch (IOException e) {
                                System.out.println("Error writing to file: " + e.getMessage());
                            }
                            break;
                        case 2:
                            Product[] products = new Product[25];
                            try {
                                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Seller\\seller_products.txt"));
                                String line;
                                int i = 0;
                                while ((line = reader.readLine()) != null) {
                                    StringTokenizer tokenizer = new StringTokenizer(line, ",");
                                    String name = tokenizer.nextToken();
                                    double price = Double.parseDouble(tokenizer.nextToken());
                                    products[i] = new Product(name, price);
                                    i = i + 1;
                                }
                            } catch (IOException e) {
                                System.out.println("Error reading from file: " + e.getMessage());
                            }
                            int i = 0;
                            try {
                                for (Product product : products) {
                                    System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice());
                                    i = i + 1;
                                }
                            }
                            catch (Exception e)
                            {

                            }
                            CartItem[] cart = new CartItem[20];

                            i = 0;
                            while (true) {
                                System.out.print(
                                        "Enter the number of the product you want to purchase (or 'done' to finish): ");
                                String input = scanner.next();
                                if (input.equalsIgnoreCase("done")) {
                                    break;
                                }
                                int productIndex = Integer.parseInt(input) - 1;
                                Product product = products[productIndex];
                                System.out.print("Enter the quantity: ");
                                int quantity = scanner.nextInt();
                                cart[i] = new CartItem(product, quantity);
                                i = i + 1;

                                double total = 0;
                                try {
                                    for (CartItem item : cart) {
                                        total += item.getProduct().getPrice() * item.getQuantity();
                                    }
                                }
                                catch (Exception e)
                                {

                                }
                                System.out.println("Total: $" + total);
                            }
                            double total=0;
                            System.out.println("Items in cart:");
                            try {
                                for (CartItem item : cart) {
                                    Product product = item.getProduct();
                                    int quantity = item.getQuantity();
                                    double price = product.getPrice();
                                    total = total + price * quantity;
                                    System.out.println(product.getName() + " - " + quantity + " x $" + price + " = $"
                                            + (price * quantity));
                                }
                            }
                            catch (Exception e)
                            {

                            }
                            System.out.println("Total bill: $" + total);
                            break;
                    }
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
                break;
        }
    }
}
