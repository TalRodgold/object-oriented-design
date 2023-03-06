package Seasons;
/**

 An interface representing objects that have seasons.
 */
public interface Seasonable {

    /**

     Returns the current season of the object.
     @return the current season of the object
     */
    Season getCurrentSeason();
    /**

     Changes the current season of the object to the next one in the cycle: FALL -> WINTER -> SPRING -> SUMMER -> FALL.
     */
    void changeSeason();
    /**

     Returns a string representation of the object.
     @return a string representation of the object
     */
    String TOString();
}