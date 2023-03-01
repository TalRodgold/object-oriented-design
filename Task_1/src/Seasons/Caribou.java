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
        switch (this.getCurrentSeason()) {
            case WINTER -> {
                this.color = Color.WHITE;
                this.migration = "I am migrating south. ";
            }
            case SPRING -> {this.color = Color.BROWN;}
            case SUMMER -> {migration = ": I am migrating north. ";}
        }    }
}
