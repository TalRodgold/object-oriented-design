package Seasons;
import java.util.Arrays;
public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();
    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }

    static String reportAll(Seasonable[] seasonables) {
        String to_return = "";
        for (Seasonable seasonable : seasonables) {
            to_return += seasonable.toString() + "\n";
        }
        return to_return;
    }
}
