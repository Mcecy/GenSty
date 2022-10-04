package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter Client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        Date birthDate = sdf.parse(sc.next());
        sc.nextLine();

        Client client = new Client(name, email, birthDate);

        System.out.println("\nEnter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("How many items to this order: ");
        Integer n = sc.nextInt();
        sc.nextLine();

        List<OrderItem> items = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            name = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(name, price);
            OrderItem item = new OrderItem(quantity, price, product);
            items.add(item);
        }

        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        for (OrderItem item : items) {
            order.addItem(item);
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}
