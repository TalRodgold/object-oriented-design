package Seasons;

public class Bear extends Animal {

    Bear(int weight, Season season) {
        // TODO: Implement.
        super(weight,season,season.get_color_for_Season(season, "bear"));
    }
    @Override
    public String toString() {
        return "Bear. " + super.TOString();
    }
    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.FALL){
            this.weight = (int) ((int) this.weight + 0.25 * this.weight);
        }
        else if (this.getCurrentSeason() == Season.WINTER){
            this.weight = (int) ((int) this.weight - 0.2 * this.weight);
        }
        else if (this.getCurrentSeason() == Season.SPRING){
            this.weight = (int) ((int) this.weight - 0.25 * this.weight);
        }
        else if (this.getCurrentSeason() == Season.SUMMER){
            this.weight = (int) ((int) this.weight * 1.33333);
        }
        this.color = Color.BROWN;
    }
}
