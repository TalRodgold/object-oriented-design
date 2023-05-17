package Ex05IBLSkeleton;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

class Program
{
    public static void main(String args[]) {
        Customer my = new Customer("customer: 7 name: customer7 tier: 3");
        IBL myBl = new BL();

        System.out.println("---------getProductById:--------");
        System.out.println(myBl.getProductById(495L));

        System.out.println("---------getOrderById:--------");
        System.out.println(myBl.getOrderById(241L));

        System.out.println("---------getCustomerById:--------");
        System.out.println(myBl.getCustomerById(284L));

        System.out.println("---------getProducts:--------");
        myBl.getProducts(ProductCategory.Accessories, 50.0).forEach(System.out::print);

        System.out.println("---------popularCustomers:--------");
        myBl.popularCustomers().forEach(System.out::print);

        System.out.println("---------getCustomerOrders:--------");
        myBl.getCustomerOrders(83L).forEach(System.out::print);

        System.out.println("---------numberOfProductInOrder:--------");
        System.out.println(myBl.numberOfProductInOrder(76L));

        System.out.println("---------getPopularOrderedProduct:--------");
        myBl.getPopularOrderedProduct(55).forEach(System.out::print);

        System.out.println("---------getOrderProducts:--------");
        myBl.getOrderProducts(24L).forEach(System.out::print);

        System.out.println("---------getCustomersWhoOrderedProduct:--------");
        myBl.getCustomersWhoOrderedProduct (18L).forEach(System.out::print);

        System.out.println("---------getMaxOrderedProduct:--------");
        myBl.getMaxOrderedProduct();
        System.out.println(myBl.getMaxOrderedProduct());

        System.out.println("---------sumOfOrder:--------");
        System.out.println(myBl.sumOfOrder(24L));

        System.out.println("---------getExpensiveOrders:--------");
        myBl.getExpensiveOrders(7000).forEach(System.out::print);

        System.out.println("---------ThreeTierCustomerWithMaxOrders:--------");
        myBl.ThreeTierCustomerWithMaxOrders().forEach(System.out::print);
    }
} 