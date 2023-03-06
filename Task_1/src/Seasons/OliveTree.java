package Seasons;

public class OliveTree extends Tree {

    /**
     * Initializes a new instance of the OliveTree class with the specified height and season.
     *
     * @param height the height of the tree in centimeters
     * @param season the current season of the tree
     */
    OliveTree(int height, Season season) {
        super(height, season, season.get_color_for_Season(season, "olive"), season.get_fruit_for_season(season, "olive"));
    }

    /**
     * Returns a string that represents the current state of the OliveTree object.
     *
     * @return a string that represents the current state of the OliveTree object
     */
    @Override
    public String toString() {
        return "Olive tree. " + super.TOString();
    }

    /**
     * Changes the current season of the tree and updates its properties accordingly.
     */
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
