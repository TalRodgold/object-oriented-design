package Seasons;

public class Bear extends Animal {
        private String sleep;
    Bear(int weight, Season season) {
        super(weight,season,season.get_color_for_Season(season, "bear"));
        sleep = "";
    }
    @Override
    public String toString() {
        return "Bear. " + this.sleep + super.TOString();
    }
    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.FALL){
            this.weight = (int)( this.weight + 0.25 * this.weight);
            this.sleep = "";
        }
        else if (this.getCurrentSeason() == Season.WINTER){
            this.weight = (int)( this.weight - 0.2 * this.weight);
            this.sleep = "I am sleeping. ";
        }
        else if (this.getCurrentSeason() == Season.SPRING){
            this.weight = (int) ( this.weight - 0.25 * this.weight);
            this.sleep = "";
        }
        else if (this.getCurrentSeason() == Season.SUMMER){
            this.weight = (int) ( this.weight * 1.33333);
            this.sleep = "";
        }
        this.color = Color.BROWN;
    }
}
