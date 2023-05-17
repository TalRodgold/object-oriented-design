package Ex05IBLSkeleton;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Customer {
    private long id;
    private String name;
    private int tier;
    public static String customerRegex = "customer:\\s(\\d+)";
    public static String nameRegex = "name:\\s([^ ]+)";
    public static String tierRegex = "tier:\\s(\\d+)";

    public Customer(String customerInfo)
    {
       id = Long.parseLong(extractValue(customerInfo, customerRegex));
       name = extractValue(customerInfo, nameRegex);
       tier = Integer.parseInt(extractValue(customerInfo, tierRegex));
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

    private static String extractValue(String text, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        MatchResult matchResult = matcher.toMatchResult();
        return matchResult.group(1);
    }
}