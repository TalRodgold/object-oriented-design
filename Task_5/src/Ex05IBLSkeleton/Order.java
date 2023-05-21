package Ex05IBLSkeleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents an order in the system.
 */
public class Order {

    private long orderId;
    private Date orderDate;
    private Date deliveryDate;
    private OrderStatus status;
    private long customrId;

    public static String orderRegex = "order:\\s(\\d+)";
    public static String orderDateRegex = "order date:\\s(\\d{2}/\\d{2}/\\d{4})";
    public static String deliveryDateRegex = "delivery date:\\s(\\d{2}/\\d{2}/\\d{4})";
    public static String statusRegex = "status:\\s([A-Za-z]+)";
    public static String customrRegex = "customr id:\\s(\\d+)";

    /**
     * Constructs an Order object based on the given order information string.
     *
     * @param orderInfo the order information string
     */
    public Order(String orderInfo) {
        String parsed_order = extractValue(orderRegex, orderInfo);
        String parsed_orderDate  = extractValue(orderDateRegex, orderInfo);
        String parsed_deliveryDate  = extractValue(deliveryDateRegex, orderInfo);
        String parsed_status  = extractValue(statusRegex, orderInfo);
        String parsed_customr  = extractValue(customrRegex, orderInfo);

        orderId = Long.parseLong(parsed_order);
        try {
            orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(parsed_orderDate);
        } catch (java.text.ParseException e) {
            System.out.println("ERROR");
        }
        try {
            deliveryDate = new SimpleDateFormat("dd/MM/yyyy").parse(parsed_deliveryDate);
        } catch (java.text.ParseException e) {
            System.out.println("ERROR");
        }
        status = OrderStatus.valueOf(parsed_status);
        customrId = Long.parseLong(parsed_customr);
    }

    /**
     * Constructs an Order object with the specified attributes.
     *
     * @param Oid the order ID
     * @param OorderDate the order date
     * @param OdeliveryDate the delivery date
     * @param Ostatus the order status
     * @param OcustomrId the customer ID
     */
    public Order(long Oid, Date OorderDate, Date OdeliveryDate, OrderStatus Ostatus, long OcustomrId)
    {
        setOrderId(Oid);
        setOrderDate(OorderDate);
        setDeliveryDate(OdeliveryDate);
        setStatus(Ostatus);
        setCustomrId(OcustomrId);
    }

    /**
     * Returns a string representation of the Order object.
     *
     * @return a string representation of the Order object
     */
    public String toString()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return "order: "+ getOrderId() + " order date: "+ ft.format(getOrderDate()) +" delivery date: "+ ft.format(getDeliveryDate()) + " status: "+ getStatus() + " customr id: "+ getCustomrId()+"\n";
    }

    // Getter and setter methods

    /**
     * Returns the order ID.
     *
     * @return the order ID
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID.
     *
     * @param orderId the order ID to set
     */
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    /**
     * Returns the order date.
     *
     * @return the order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date.
     *
     * @param orderDate the order date to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Returns the delivery date.
     *
     * @return the delivery date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the delivery date.
     *
     * @param deliveryDate the delivery date to set
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Returns the order status.
     *
     * @return the order status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Sets the order status.
     *
     * @param status the order status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Returns the customer ID.
     *
     * @return the customer ID
     */
    public long getCustomrId() {
        return customrId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customrId the customer ID to set
     */
    public void setCustomrId(long customrId) {
        this.customrId = customrId;
    }

    /**
     * Extracts the value from the text using the specified regular expression.
     *
     * @param regex the regular expression pattern
     * @param text the text to extract from
     * @return the extracted value
     */
    private static String extractValue(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            return matchResult.group(1);
        }
        return "FAILED"; // Return failed if no match is found
    }
}
