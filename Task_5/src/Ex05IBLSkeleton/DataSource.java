package Ex05IBLSkeleton;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors.*;
import java.util.stream.Collectors;
import java.util.stream.*;




public class DataSource {

    public static List<Customer> allCustomers;
    public static List<Order> allOrders;
    public static List<Product> allProducts;
    public static List<OrderProduct> allOrderProducts;
    // Update this path according to your data files location
    public static String basePath = "data/Ex05IBL/";
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

                Stream<String> stream = Files.lines(Paths.get(customersPath));
                Iterator<String> customersIterator = stream.iterator();
                while (customersIterator.hasNext()) {
                    Customer customer = new Customer(customersIterator.next());
                    allCustomers.add(customer);

                    //System.out.println(customersIterator.next());
                }
                if (allCustomers.isEmpty()){
                    throw new IOException();}
                return allCustomers;

   }

    public static List<Order> readOrdersfromFile() throws IOException {
        //To Do
        return null;
    }

    public static List<Product> readProductsfromFile() throws IOException {
        //To Do
        return null;
    }

    public static List<OrderProduct> readOrderProductsfromFile() throws IOException {
        //To Do
        return null;
    }
}


