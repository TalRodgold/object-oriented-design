package Ex05IBLSkeleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

/**
 * Represents a customer in the system.
 */
public class Customer {
    private long id;
    private String name;
    private int tier;
    public static String customerRegex = "customer:\\s(\\d+)";
    public static String nameRegex = "name:\\s([^ ]+)";
    public static String tierRegex = "tier:\\s(\\d+)";

    /**
     * Constructs a Customer object by parsing the customer information string.
     *
     * @param customerInfo The customer information string.
     */
    public Customer(String customerInfo) {
        String parsedCustomer = extractValue(customerRegex, customerInfo);
        String parsedName = extractValue(nameRegex, customerInfo);
        String parsedTier = extractValue(tierRegex, customerInfo);
        id = Long.parseLong(parsedCustomer);
        name = parsedName;
        tier = Integer.parseInt(parsedTier);
    }

    /**
     * Constructs a Customer object with the specified ID, name, and tier.
     *
     * @param id   The ID of the customer.
     * @param name The name of the customer.
     * @param tier The tier of the customer.
     */
    public Customer(long id, String name, int tier) {
        setId(id);
        setName(name);
        setTier(tier);
    }

    /**
     * Returns a string representation of the Customer object.
     *
     * @return A string representation of the Customer object.
     */
    @Override
    public String toString() {
        return "customer: " + getId() + " name: " + getName() + " tier: " + getTier() + "\n";
    }

    /**
     * Retrieves the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id The ID to set for the customer.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name to set for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the tier of the customer.
     *
     * @return The tier of the customer.
     */
    public int getTier() {
        return tier;
    }

    /**
     * Sets the tier of the customer.
     *
     * @param tier The tier to set for the customer.
     */
    public void setTier(int tier) {
        this.tier = tier;
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
