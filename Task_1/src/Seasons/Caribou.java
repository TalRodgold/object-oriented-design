package Seasons;

public class Caribou extends Animal {

    private String  migration;

    Caribou(int weight, Season season) {
        super(weight, season, season.get_color_for_Season(season, "caribou"));
        migration = "";
    }

    @Override
    public String toString() {
        return "Caribou: " + this.migration + super.TOString();
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.WINTER) {
            this.color = Color.WHITE;
            this.migration = "I am migrating south. ";
        } else if (this.getCurrentSeason() == Season.SPRING) {
            this.color = Color.BROWN;
        } else if (this.getCurrentSeason() == Season.SUMMER) {
            migration = ": I am migrating north. ";
        }
    }
}
