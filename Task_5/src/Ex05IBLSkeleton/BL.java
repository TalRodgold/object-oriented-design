package Ex05IBLSkeleton;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Implementation of the IBL interface.
 */
public class BL implements IBL {

    /**
     * Retrieves a product by its ID.
     *
     * @param productId The ID of the product.
     * @return The product with the given ID, or null if not found.
     */
    @Override
    public Product getProductById(long productId) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param orderId The ID of the order.
     * @return The order with the given ID, or null if not found.
     */
    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream()
                .filter(item -> item.getOrderId()== orderId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId The ID of the customer.
     * @return The customer with the given ID, or null if not found.
     */
    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream()
                .filter(item -> item.getId() == customerId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves a list of products based on the category and maximum price.
     *
     * @param cat   The product category.
     * @param price The maximum price.
     * @return A list of products that match the category and price criteria.
     */
    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getCategory() == cat && item.getPrice() <= price)
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of customers who are in tier 3 (most profitable) and have placed more than 10 orders.
     *
     * @return A list of customers who meet the criteria.
     */
    @Override
    public List<Customer> popularCustomers() {
        return DataSource.allCustomers.stream()
                .filter(item -> item.getTier() == 3 && DataSource.allOrders.stream()
                        .filter(item2 -> item2.getCustomrId() == item.getId())
                        .collect(Collectors.toList()).size() > 10)
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of orders placed by a specific customer.
     *
     * @param customerId The ID of the customer.
     * @return A list of orders placed by the customer.
     */
    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allOrders.stream()
                .filter(order -> order.getCustomrId() == customerId)
                .sorted(Comparator.comparingLong(Order::getOrderId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the number of different products ordered in a specific order.
     *
     * @param orderId The ID of the order.
     * @return The number of different products ordered.
     */
    @Override
    public long numberOfProductInOrder(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .map(OrderProduct::getProductId)
                .distinct()
                .count();
    }

    /**
     * Retrieves a list of popular products that have been ordered at least the specified number of times.
     *
     * @param orderedTimes The minimum number of times a product should be ordered to be considered popular.
     * @return A list of popular products.
     */
    @Override
    public List<Product> getPopularOrderedProduct(int orderedTimes) {
        Map<Long, Integer> productOccurrences = DataSource.allOrderProducts.stream()
                .collect(groupingBy(OrderProduct::getProductId,
                        Collectors.summingInt(OrderProduct::getQuantity)));

        return productOccurrences.entrySet().stream()
                .filter(entry -> entry.getValue() >= orderedTimes)
                .map(entry -> getProductById(entry.getKey()))
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of products ordered in a specific order.
     *
     * @param orderId The ID of the order.
     * @return A list of products ordered in the specified order.
     */
    @Override
    public List<Product> getOrderProducts(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .map(orderProduct -> getProductById(orderProduct.getProductId()))
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of customers who have purchased a product with the specified ID.
     *
     * @param productId The ID of the product.
     * @return A list of customers who have purchased the product.
     */
    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        return DataSource.allOrders.stream()
                .filter(order -> {
                    List<OrderProduct> orderProducts = getOrderProductsByOrderId(order.getOrderId());
                    return orderProducts.stream()
                            .anyMatch(orderProduct -> orderProduct.getProductId() == productId);
                })
                .map(order -> getCustomerById(order.getCustomrId()))
                .distinct()
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());
    }

    private List<OrderProduct> getOrderProductsByOrderId(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .collect(Collectors.toList());
    }


    /**
     * Retrieves the product that has been ordered the most times.
     *
     * @return The product that has been ordered the most times.
     */
    @Override
    public Product getMaxOrderedProduct() {
        return getProductById(DataSource.allOrderProducts.stream()
                .collect(groupingBy(OrderProduct::getProductId))
                .entrySet().stream()
                .max(Comparator.comparing(item -> item.getValue().size()))
                .orElse(null)
                .getKey());
    }

    /**
     * Calculates the total price of an order.
     *
     * @param orderId The ID of the order.
     * @return The total price of the order.
     */
    @Override
    public double sumOfOrder(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .mapToDouble(orderProduct -> {
                    Product product = getProductById(orderProduct.getProductId());
                    return product.getPrice() * orderProduct.getQuantity();
                })
                .sum();
    }

    /**
     * Retrieves a list of expensive orders with a total price greater than the specified price.
     *
     * @param price The minimum price for an order to be considered expensive.
     * @return A list of expensive orders.
     */
    @Override
    public List<Order> getExpensiveOrders(double price) {
        return DataSource.allOrders.stream()
                .filter(order -> calculateTotalCost(order) > price)
                .sorted(Comparator.comparingLong(Order::getOrderId))
                .collect(Collectors.toList());
    }

    private double calculateTotalCost(Order order) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == order.getOrderId())
                .mapToDouble(orderProduct -> {
                    Product product = getProductByIdInner(orderProduct.getProductId());
                    return product.getPrice() * orderProduct.getQuantity();
                })
                .sum();
    }

    private Product getProductByIdInner(long productId) {
        return DataSource.allProducts.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves a list of tier 3 customers (most profitable) who have placed the maximum number of orders.
     *
     * @return A list of tier 3 customers with the maximum number of orders.
     */
    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        int maxOrderCount = DataSource.allCustomers.stream()
                .filter(customer -> customer.getTier() == 3)
                .mapToInt(this::getCustomerOrderCount)
                .max()
                .orElse(0);

        return DataSource.allCustomers.stream()
                .filter(customer -> customer.getTier() == 3 && getCustomerOrderCount(customer) == maxOrderCount)
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());
    }

    // Helper method to get the number of orders for a customer
    private int getCustomerOrderCount(Customer customer) {
        return (int) DataSource.allOrders.stream()
                .filter(order -> order.getCustomrId() == customer.getId())
                .count();
    }
}
