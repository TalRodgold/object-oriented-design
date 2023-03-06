package Seasons;

public class Bear extends Animal {
    private String sleep;

    Bear(int weight, Season season) {
        // Initializes the animal with given weight, season, and color based on the season.
        // If the season is winter, sets sleep to "I am sleeping." Otherwise, sets sleep to an empty string.
        super(weight, season, season.get_color_for_Season(season, "bear"));
        if (season == Season.WINTER) {
            sleep = "I am sleeping. ";
        } else {
            sleep = "";
        }
    }

    @Override
    public String toString() {
        // Returns a string representation of the bear, including whether it is sleeping and its other attributes.
        return "Bear. " + this.sleep + super.TOString();
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.FALL) {
            // In fall, the bear gains 25% of its weight and wakes up.
            this.weight = (int) Math.round(this.weight + 0.25 * this.weight);
            this.sleep = "";
        } else if (this.getCurrentSeason() == Season.WINTER) {
            // In winter, the bear loses 20% of its weight and goes to sleep.
            this.weight = (int) Math.round(this.weight - 0.2 * this.weight);
            this.sleep = "I am sleeping. ";
        } else if (this.getCurrentSeason() == Season.SPRING) {
            // In spring, the bear loses 25% of its weight and wakes up.
            this.weight = (int) Math.round(this.weight - 0.25 * this.weight);
            this.sleep = "";
        } else if (this.getCurrentSeason() == Season.SUMMER) {
            // In summer, the bear gains 33.33% of its weight and wakes up.
            this.weight = (int) Math.round(this.weight * 1.33333);
            this.sleep = "";
        }
        // Sets the color of the bear to brown, regardless of the season.
        this.color = Color.BROWN;
    }
}
