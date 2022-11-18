package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter Client Data: ");
        System.out.print("name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine()); 

        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(new Date(), status, client);
        
        System.out.println("How many items to this order?");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addOrderItem(orderItem);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}
