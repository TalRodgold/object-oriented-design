package Seasons;

import java.util.Arrays;

public class SeasonUtil {

    // An array of all possible seasons
    public static final Season[] SEASONS = Season.values();

    /**
     * Sorts an array of Comparable objects according to their natural order
     * @param seasonables An array of objects implementing the Comparable interface
     */
    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }

    /**
     * Generates a report of all Seasonable objects in the array, with each object on a new line
     * @param seasonables An array of objects implementing the Seasonable interface
     * @return A string representation of all Seasonable objects in the array
     */
    static String reportAll(Seasonable[] seasonables) {
        String to_return = "";
        for (Seasonable seasonable : seasonables) {
            if(seasonables[seasonables.length -1] == seasonable)
                to_return += seasonable.toString();
            else
            {
                to_return += seasonable.toString() + "\n";
            }
        }
        return to_return;
    }
}
