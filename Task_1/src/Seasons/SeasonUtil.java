package Seasons;

public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();
    public static void sortSeasonable(Comparable[] seasonables) {
        int n = seasonables.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (seasonables[j].compareTo(seasonables[j+1]) == 1) {
                    // swap arr[j] and arr[j+1]
                    Comparable temp = seasonables[j];
                    seasonables[j] = seasonables[j+1];
                    seasonables[j+1] = temp;
                }
            }
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
