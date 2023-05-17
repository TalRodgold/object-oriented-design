package Ex05IBLSkeleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;

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

    public Order(String orderInfo) throws ParseException {
        String parsed_order = extractValue(orderRegex, orderInfo);
        String parsed_orderDate  = extractValue(orderDateRegex, orderInfo);
        String parsed_deliveryDate  = extractValue(deliveryDateRegex, orderInfo);
        String parsed_status  = extractValue(statusRegex, orderInfo);
        String parsed_customr  = extractValue(customrRegex, orderInfo);

        orderId = Long.parseLong(parsed_order);
        orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(parsed_orderDate);
        deliveryDate = new SimpleDateFormat("dd/MM/yyyy").parse(parsed_deliveryDate);
        status = OrderStatus.valueOf(parsed_status);
        customrId = Long.parseLong(parsed_customr);
    }

    public Order(long Oid, Date OorderDate, Date OdeliveryDate, OrderStatus Ostatus, long OcustomrId)
    {
        setOrderId(Oid);
        setOrderDate(OorderDate);
        setDeliveryDate(OdeliveryDate);
        setStatus(Ostatus);
        setCustomrId(OcustomrId);
    }



    public String toString()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return "order: "+ getOrderId() + " order date: "+ ft.format(getOrderDate()) +" delivery date: "+ ft.format(getDeliveryDate()) + " status: "+ getStatus() + " customr id: "+ getCustomrId()+"\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getCustomrId() {
        return customrId;
    }

    public void setCustomrId(long customrId) {
        this.customrId = customrId;
    }

    private static String extractValue(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            return matchResult.group(1);
        }
        return "FAILED"; // Return failed if no match is found
    }
}