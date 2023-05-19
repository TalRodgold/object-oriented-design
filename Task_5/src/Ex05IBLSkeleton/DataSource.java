package Ex05IBLSkeleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataSource {

    public static List<Customer> allCustomers;
    public static List<Order> allOrders;
    public static List<Product> allProducts;
    public static List<OrderProduct> allOrderProducts;
    // Update this path according to your data files location
    public static String basePath = "Task_5/src/Ex05IBLSkeleton/data_files/";
    public static String customersPath = basePath +"customers.txt";
    public static String ordersPath = basePath +"orders.txt";
    public static String productsPath = basePath +"products.txt";
    public static String orderProductPath = basePath +"orderProduct.txt";

    static
    {
        try {
            allCustomers = readCustomersfromFile();
            allOrders = readOrdersfromFile();
            allProducts = readProductsfromFile();
            allOrderProducts = readOrderProductsfromFile();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static List<Customer> readCustomersfromFile() throws IOException {
        List<Customer> new_list = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(customersPath));
        Iterator<String> customersIterator = stream.iterator();
        while (customersIterator.hasNext()) {
            Customer customer = new Customer(customersIterator.next());
            new_list.add(customer);
        }
        return new_list;
   }

    public static List<Order> readOrdersfromFile() throws IOException {
        List<Order> new_list = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(ordersPath));
        Iterator<String> ordersIterator = stream.iterator();
        while (ordersIterator.hasNext()) {
            Order order = new Order(ordersIterator.next());
            new_list.add(order);
        }
        return new_list;
    }

    public static List<Product> readProductsfromFile() throws IOException {
        List<Product> new_list = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(productsPath));
        Iterator<String> productsIterator = stream.iterator();
        while (productsIterator.hasNext()) {
            Product products = new Product(productsIterator.next());
            new_list.add(products);
        }
        return new_list;
    }

    public static List<OrderProduct> readOrderProductsfromFile() throws IOException {
        List<OrderProduct> new_list = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(orderProductPath));
        Iterator<String> orderProductIterator = stream.iterator();
        while (orderProductIterator.hasNext()) {
            OrderProduct orderProduct = new OrderProduct(orderProductIterator.next());
            new_list.add(orderProduct);
        }
        return new_list;
    }
}


