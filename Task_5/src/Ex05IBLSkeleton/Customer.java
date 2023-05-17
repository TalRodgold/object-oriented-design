package Ex05IBLSkeleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;


public class Customer {
    private long id;
    private String name;
    private int tier;
    public static String customerRegex = "customer:\\s(\\d+)";
    public static String nameRegex = "name:\\s([^ ]+)";
    public static String tierRegex = "tier:\\s(\\d+)";

    public Customer(String customerInfo)
    {
        String parsed_customer = extractValue(customerRegex, customerInfo);
        String parsed_name  = extractValue(nameRegex, customerInfo);
        String parsed_tier  = extractValue(tierRegex, customerInfo);
        id = Long.parseLong(parsed_customer);
        name = parsed_name;
        tier = Integer.parseInt(parsed_tier);
    }

    public Customer(long Cid,String Cname, int Ctier)
    {
        setId(Cid);
        setName(Cname);
        setTier(Ctier);
    }

    public String toString()
    {
        return "customer: "+ getId() + " name: "+ getName() +" tier: "+ getTier()+"\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

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