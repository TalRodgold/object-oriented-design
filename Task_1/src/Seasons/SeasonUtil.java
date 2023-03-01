package Seasons;

import java.util.ArrayList;
import java.util.Arrays;

public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();
    public static void sortSeasonable(Comparable[] seasonables) {
        for (Comparable seasonable : seasonables) {
            System.out.println(seasonable.toString());
        }
    }

    static String reportAll(Seasonable[] seasonables) {
        String to_return = "";
        for (Seasonable seasonable : seasonables) {
            to_return += seasonable.toString() + "\n";
        }
        return to_return;
    }
}
