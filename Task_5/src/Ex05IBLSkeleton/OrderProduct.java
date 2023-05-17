package Ex05IBLSkeleton;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;

public class OrderProduct {
    private long orderId;
    private long productId;
    private int quantity;
    public static String ordidRegex = "ord id:\\s(\\d+)";
    public static String prodidRegex = "prod id:\\s(\\d+)";
    public static String quantityRegex = "quantity:\\s(\\d+)";

    public OrderProduct(String orderInfo)
    {
        String parsed_ordid = extractValue(ordidRegex, orderInfo);
        String parsed_prodid  = extractValue(prodidRegex, orderInfo);
        String parsed_quantity  = extractValue(quantityRegex, orderInfo);
        orderId = Long.parseLong(parsed_ordid);
        productId = Long.parseLong(parsed_prodid);
        quantity = Integer.parseInt(parsed_quantity);
    }

    public OrderProduct(long oId, long pId, int quantity)
    {
        setOrderId(oId);
        setProductId(pId);
        setQuantity(quantity);
    }

    public String toString()
    {
        return "ord id: "+ getOrderId() + " prod id: "+ getProductId() +" quantity: "+ getQuantity()+"\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
