package Seasons;

public class FigTree extends Tree {


    FigTree(int height, Season season) {
        super(height,season,season.get_color_for_Season(season, "fig"), season.get_fruit_for_season(season, "fig"));
    }

    @Override
    public String toString() {
        return "Fig tree. " + super.TOString();
    }
    @Override
    public void changeSeason() {
        super.changeSeason();
        if (this.getCurrentSeason() == Season.FALL){
            this.height = this.height + 20;
            this.leavesColor = Color.YELLOW;
            this.fruit = false;
        }
        else if (this.getCurrentSeason() == Season.WINTER){
            this.height = this.height + 20;
            this.leavesColor = null;
            this.fruit = false;
        }
        else if (this.getCurrentSeason() == Season.SPRING){
            this.height = this.height + 30;
            this.leavesColor = Color.GREEN;
            this.fruit = false;
        }
        else if (this.getCurrentSeason() == Season.SUMMER){
            this.height = this.height + 20;
            this.fruit = true;
        }
    }
}
