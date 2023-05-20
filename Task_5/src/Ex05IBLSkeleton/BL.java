package Ex05IBLSkeleton;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class BL implements IBL {
    public Product getProductById(long productId) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream()
                .filter(item -> item.getOrderId()== orderId)
                .findFirst()
                .orElse(null);
    }

    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream()
                .filter(item -> item.getId() == customerId)
                .findFirst()
                .orElse(null);    }


    public List<Product> getProducts(ProductCategory cat, double price) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getCategory() == cat && item.getPrice() <= price)
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
    }


    public List<Customer> popularCustomers() {
        return DataSource.allCustomers.stream()
                .filter(item -> item.getTier() == 3 && DataSource.allOrders.stream()
                        .filter(item2 -> item2.getCustomrId() == item.getId())
                        .collect(Collectors.toList()).size() > 10)
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());
        }


    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allOrders.stream()
                .filter(order -> order.getCustomrId() == customerId)
                .sorted(Comparator.comparingLong(Order::getOrderId))
                .collect(Collectors.toList());
    }

    public long numberOfProductInOrder(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .mapToLong(OrderProduct::getProductId) .distinct()
                .count();
    }

    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        Map<Long, Integer> productOccurrences = DataSource.allOrderProducts.stream()
                .collect(groupingBy(OrderProduct::getProductId,
                        Collectors.summingInt(OrderProduct::getQuantity)));

        return productOccurrences.entrySet().stream()
                .filter(entry -> entry.getValue() >= orderedtimes)
                .map(entry -> getProductById(entry.getKey()))
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());

    }

    public List<Product> getOrderProducts(long orderId)
    {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderId)
                .map(orderProduct -> getProductById(orderProduct.getProductId()))
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
    }

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


    public Product getMaxOrderedProduct() {
        return getProductById( DataSource.allOrderProducts.stream()
                .collect(groupingBy(OrderProduct::getProductId))
                .entrySet().stream()
                .max(Comparator.comparing(item->item.getValue().size())).orElse(null)
                .getKey());

    }

    // Helper method to retrieve the product by its ID

    public double sumOfOrder(long orderID) {
        return DataSource.allOrderProducts.stream()
                .filter(orderProduct -> orderProduct.getOrderId() == orderID)
                .mapToDouble(orderProduct -> {
                    Product product = getProductById(orderProduct.getProductId());
                    return product.getPrice() * orderProduct.getQuantity();
                })
                .sum();
    }

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


    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        int maxOrderCount = DataSource.allCustomers.stream()
                .filter(customer -> customer.getTier() == 3)
                .mapToInt(customer -> getCustomerOrderCount(customer))
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
    }}