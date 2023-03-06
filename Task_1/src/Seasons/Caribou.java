package Seasons;

public class Caribou extends Animal {

    private String  migration;

    /**
     * Initializes a new instance of the Caribou class with the specified weight and season.
     *
     * @param weight the weight of the caribou in kilograms
     * @param season the current season of the caribou
     */
    Caribou(int weight, Season season) {
        super(weight, season, season.get_color_for_Season(season, "caribou"));
        migration = "";
    }

    /**
     * Returns a string that represents the current state of the Caribou object.
     *
     * @return a string that represents the current state of the Caribou object
     */
    @Override
    public String toString() {
        return "Caribou: " + this.migration + super.TOString();
    }

    /**
     * Changes the current season of the caribou and updates its properties accordingly.
     */
    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.WINTER) {
            this.color = Color.WHITE;
            this.migration = "I am migrating south. ";
        } else if (this.getCurrentSeason() == Season.SPRING) {
            this.color = Color.BROWN;
            this.migration = "";
        } else if (this.getCurrentSeason() == Season.SUMMER) {
            migration = "I am migrating north. ";
        }
        else
            this.migration = "";
    }
}
