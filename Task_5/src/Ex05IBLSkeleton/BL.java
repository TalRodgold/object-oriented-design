package Ex05IBLSkeleton;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream()
                .filter(item -> item.getOrderId()== orderId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream()
                .filter(item -> item.getId() == customerId)
                .findFirst()
                .orElse(null);    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getCategory() == cat && item.getPrice() <= price)
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(Collectors.toList());
    }


    @Override
    public List<Customer> popularCustomers() {
        return DataSource.allCustomers.stream()
                .filter(item -> item.getTier() == 3 && DataSource.allOrders.stream()
                        .filter(item2 -> item2.getCustomrId() == item.getId())
                        .collect(Collectors.toList()).size() > 10)
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());
        }


    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product getMaxOrderedProduct() {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }
    @Override
    public double sumOfOrder(long orderID) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        return DataSource.allProducts.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

}
