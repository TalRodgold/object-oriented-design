package Ex05IBLSkeleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents the data source for the application, providing access to customers, orders, products, and order products.
 */
public class DataSource {

    public static List<Customer> allCustomers;
    public static List<Order> allOrders;
    public static List<Product> allProducts;
    public static List<OrderProduct> allOrderProducts;
    // Update this path according to your data files location
    public static String basePath = "Task_5/src/Ex05IBLSkeleton/data_files/";
    public static String customersPath = basePath + "customers.txt";
    public static String ordersPath = basePath + "orders.txt";
    public static String productsPath = basePath + "products.txt";
    public static String orderProductPath = basePath + "orderProduct.txt";

    static {
        try {
            allCustomers = readCustomersFromFile();
            allOrders = readOrdersFromFile();
            allProducts = readProductsFromFile();
            allOrderProducts = readOrderProductsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the customer data from the file and returns a list of Customer objects.
     *
     * @return A list of Customer objects.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<Customer> readCustomersFromFile() throws IOException {
        List<Customer> newList = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(customersPath));
        Iterator<String> customersIterator = stream.iterator();
        while (customersIterator.hasNext()) {
            Customer customer = new Customer(customersIterator.next());
            newList.add(customer);
        }
        return newList;
    }

    /**
     * Reads the order data from the file and returns a list of Order objects.
     *
     * @return A list of Order objects.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<Order> readOrdersFromFile() throws IOException {
        List<Order> newList = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(ordersPath));
        Iterator<String> ordersIterator = stream.iterator();
        while (ordersIterator.hasNext()) {
            Order order = new Order(ordersIterator.next());
            newList.add(order);
        }
        return newList;
    }

    /**
     * Reads the product data from the file and returns a list of Product objects.
     *
     * @return A list of Product objects.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<Product> readProductsFromFile() throws IOException {
        List<Product> newList = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(productsPath));
        Iterator<String> productsIterator = stream.iterator();
        while (productsIterator.hasNext()) {
            Product product = new Product(productsIterator.next());
            newList.add(product);
        }
        return newList;
    }

    /**
     * Reads the order product data from the file and returns a list of OrderProduct objects.
     *
     * @return A list of OrderProduct objects.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<OrderProduct> readOrderProductsFromFile() throws IOException {
        List<OrderProduct> newList = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(orderProductPath));
        Iterator<String> orderProductIterator = stream.iterator();
        while (orderProductIterator.hasNext()) {
            OrderProduct orderProduct = new OrderProduct(orderProductIterator.next());
            newList.add(orderProduct);
        }
        return newList;
    }
}
