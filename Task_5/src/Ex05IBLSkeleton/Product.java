package Ex05IBLSkeleton;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a product in the system.
 */
public class Product {
    private long productId;
    private String name;
    private ProductCategory category;
    private double price;

    public static String productIdRegex = "Product:\\s(\\d+)";
    public static String productNameRegex = "Product:\\s\\d+\\s([^:]+)\\scategory";
    public static String categoryRegex = "category:\\s([A-Za-z]+)";
    public static String priceRegex = "price:\\s([\\d.]+)";

    /**
     * Constructs a Product object based on the given order information string.
     *
     * @param orderInfo the order information string
     */
    public Product(String orderInfo)
    {
        String parsed_productId = extractValue(productIdRegex, orderInfo);
        String parsed_productName  = extractValue(productNameRegex, orderInfo);
        String parsed_category  = extractValue(categoryRegex, orderInfo);
        String parsed_price  = extractValue(priceRegex, orderInfo);

        productId = Long.parseLong(parsed_productId);
        name = parsed_productName;
        category = ProductCategory.valueOf(parsed_category);
        price = Double.parseDouble(parsed_price);
    }

    /**
     * Constructs a Product object with the specified attributes.
     *
     * @param PId the product ID
     * @param Pname the product name
     * @param Pcategory the product category
     * @param Pprice the product price
     */
    public Product(long PId, String Pname, ProductCategory Pcategory, double Pprice)
    {
        setProductId(PId);
        setName(Pname);
        setCategory(Pcategory);
        setPrice(Pprice);
    }

    /**
     * Returns a string representation of the Product object.
     *
     * @return a string representation of the Product object
     */
    @Override
    public String toString()
    {
        return "Product: "+ getProductId() + " "+ getName() +" category: "+ getCategory() + " price: "+ getPrice()+"\n";
    }

    // Getter and setter methods

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
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name the product name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public ProductCategory getCategory() {
        return category;
    }

    /**
     * Sets the product category.
     *
     * @param category the product category to set
     */
    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price the product price to set
     */
    public void setPrice(double price) {
        this.price = price;
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
