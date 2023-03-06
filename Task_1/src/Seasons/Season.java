package Seasons;
/**

 The Season enum represents the four seasons: winter, spring, summer, and fall.

 It also provides a method to get the color for a given season and type of tree or animal.

 It also provides a method to determine if a given type of tree produces fruit in a given season.
 */
public enum Season {

    WINTER, SPRING, SUMMER, FALL;

    /**

     Returns the color for the given season and type of tree or animal.
     @param s the season
     @param type the type of tree or animal
     @return the color for the given season and type of tree or animal
     */
    Color get_color_for_Season(Season s, String type) {
        switch (type) {
            case "bear":
                return Color.BROWN;
            case "caribou":
                if (s == Season.WINTER)
                    return Color.WHITE;
                else
                    return Color.BROWN;
            case "olive":
                return Color.GREEN;
            case "fig":
                if (s == Season.FALL) {
                    return Color.YELLOW;
                }
                if (s == Season.WINTER) {
                    return null;
                }
                if (s == Season.SPRING) {
                    return Color.GREEN;
                }
                if (s == Season.SUMMER) {
                    return Color.GREEN;
                }
            default:
                return null;
        }
    }
    /**

     Determines if a given type of tree produces fruit in a given season.
     @param s the season
     @param type the type of tree
     @return true if the given type of tree produces fruit in the given season, false otherwise
     */
    boolean get_fruit_for_season(Season s, String type) {
        switch (type){
            case "fig":
                if (s == Season.SUMMER)
                    return true;
                else
                    return false;
            case "olive":
                if (s == Season.FALL)
                    return true;
                else
                    return false;
            default:
                return false;
        }
    }
}