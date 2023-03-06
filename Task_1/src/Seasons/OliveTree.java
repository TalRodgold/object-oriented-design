package Seasons;

public class OliveTree extends Tree {


    OliveTree(int height, Season season) {
        // TODO: Implement.
        super(height,season,season.get_color_for_Season(season, "olive"), season.get_fruit_for_season(season, "olive"));
    }

    @Override
    public String toString() {
        return "Olive tree. " + super.TOString();

    }
    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.FALL){
            this.height = this.height + 5;
            this.fruit = true;
        }
        else if (this.getCurrentSeason() == Season.WINTER){
            this.height = this.height + 5;
            this.fruit = false;
        }
        else if (this.getCurrentSeason() == Season.SPRING){
            this.height = this.height + 10;
            this.fruit = false;
        }
        else if (this.getCurrentSeason() == Season.SUMMER){
            this.height = this.height + 10;
            this.fruit = false;
        }

    }
}
