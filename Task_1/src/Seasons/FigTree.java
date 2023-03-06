package Seasons;
public class FigTree extends Tree {

    /**
     * Initializes a new instance of the FigTree class with the specified height and season.
     *
     * @param height the height of the tree in centimeters
     * @param season the current season of the tree
     */
    public FigTree(int height, Season season) {
        super(height, season, season.get_color_for_Season(season, "fig"), season.get_fruit_for_season(season, "fig"));
    }

    /**
     * Returns a string that represents the current state of the FigTree object.
     *
     * @return a string that represents the current state of the FigTree object
     */
    @Override
    public String toString() {
        return "Fig tree. " + super.TOString();
    }

    /**
     * Changes the current season of the tree and updates its properties accordingly.
     */
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
            this.height = this.height + 30;
            this.leavesColor = Color.GREEN;
            this.fruit = true;
        }
    }
}
