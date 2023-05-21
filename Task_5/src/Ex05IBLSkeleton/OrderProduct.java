package Ex05IBLSkeleton;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents an order product in the system.
 */
public class OrderProduct {
    private long orderId;
    private long productId;
    private int quantity;
    public static String ordidRegex = "ord id:\\s(\\d+)";
    public static String prodidRegex = "prod id:\\s(\\d+)";
    public static String quantityRegex = "quantity:\\s(\\d+)";

    /**
     * Constructs an OrderProduct object based on the given order information string.
     *
     * @param orderInfo the order information string
     */
    public OrderProduct(String orderInfo)
    {
        String parsed_ordid = extractValue(ordidRegex, orderInfo);
        String parsed_prodid  = extractValue(prodidRegex, orderInfo);
        String parsed_quantity  = extractValue(quantityRegex, orderInfo);
        orderId = Long.parseLong(parsed_ordid);
        productId = Long.parseLong(parsed_prodid);
        quantity = Integer.parseInt(parsed_quantity);
    }

    /**
     * Constructs an OrderProduct object with the specified attributes.
     *
     * @param oId the order ID
     * @param pId the product ID
     * @param quantity the quantity
     */
    public OrderProduct(long oId, long pId, int quantity)
    {
        setOrderId(oId);
        setProductId(pId);
        setQuantity(quantity);
    }

    /**
     * Returns a string representation of the OrderProduct object.
     *
     * @return a string representation of the OrderProduct object
     */
    @Override
    public String toString()
    {
        return "ord id: "+ getOrderId() + " prod id: "+ getProductId() +" quantity: "+ getQuantity()+"\n";
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
     * Returns the product ID.
     *
     * @return the product ID
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Sets the product ID.
     *
     * @param productId the product ID to set
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * Returns the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
