package Ex05IBLSkeleton;

import java.text.SimpleDateFormat;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;

public class Product
{
    private long ProductId;
    private String name;
    private ProductCategory category;
    private double price;

    public static String productIdRegex = "Product:\\s(\\d+)";
    public static String productNameRegex = "product:\\s(\\d+)\\s([A-Za-z0-9]+)";
    public static String categoryRegex = "category:\\s([A-Za-z]+)";
    public static String priceRegex = "price:\\s([\\d.]+)";

    public Product(String orderInfo)
    {
        String parsed_productId = extractValue(productIdRegex, orderInfo);
        String parsed_productName  = extractValue(productNameRegex, orderInfo);
        String parsed_category  = extractValue(categoryRegex, orderInfo);
        String parsed_price  = extractValue(priceRegex, orderInfo);

        ProductId = Long.parseLong(parsed_productId);
        name = parsed_productName;
        category = ProductCategory.valueOf(parsed_category);
        price = Double.parseDouble(parsed_price);
    }

    public Product(long PId, String Pname, ProductCategory Pcategory, double Pprice)
    {
        setProductId(PId);
        setName(Pname);
        setCategory(Pcategory);
        setPrice(Pprice);

    }


    public String toString()
    {
        return "Product: "+ getProductId() + " "+ getName() +" category: "+ getCategory() + " price: "+ getPrice()+"\n";
    }

    public long getProductId() {
        return ProductId;
    }

    public void setProductId(long productId) {
        ProductId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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