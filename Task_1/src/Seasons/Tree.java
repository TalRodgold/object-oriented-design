package Seasons;

/**
 * An abstract class representing a tree that has a height, leaves color, and seasonal fruit-bearing ability.
 * Implements the Comparable and Seasonable interfaces.
 */
public abstract class Tree implements Comparable, Seasonable {

    protected int height;
    protected Season season;
    protected Color leavesColor;
    protected boolean fruit;

    /**
     * Constructor for the Tree class.
     * @param height the height of the tree.
     * @param season the current season.
     * @param leavesColor the color of the tree's leaves.
     * @param given_fruit whether or not the tree bears fruit in its current season.
     */
    Tree(int height, Season season, Color leavesColor, boolean given_fruit){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
        this.fruit = given_fruit;
    }

    /**
     * Gets the current season of the tree.
     * @return the current season of the tree.
     */
    @Override
    public Season getCurrentSeason() {
        return season;
    }

    /**
     * Compares the height of this tree to another tree.
     * @param o the tree to compare to.
     * @return 1 if this tree is taller, -1 if it is shorter, 0 if they are the same height.
     */
    @Override
    public int compareTo(Object o) {
        if (this.height > ((Tree)o).height){
            return 1;
        }
        else if (this.height < ((Tree)o).height){
            return -1;
        }
        return 0;
    }

    /**
     * Changes the current season of the tree.
     */
    @Override
    public void changeSeason(){
        if (this.season == Season.FALL){
            this.season = Season.WINTER;
        }
        else if (this.season == Season.WINTER){
            this.season = Season.SPRING;
        }
        else if (this.season == Season.SPRING){
            this.season = Season.SUMMER;
        }
        else if (this.season == Season.SUMMER){
            this.season = Season.FALL;
        }
    }

    /**
     * Returns a string representation of the tree, including its height, leaves color, and fruit-bearing ability.
     * @return a string representation of the tree.
     */
    @Override
    public String TOString(){
        if (this.leavesColor == null){
            return "My height is: " + this.height + " and I have no leaves";
        }
        if (this.fruit){
            return "I give fruit. My height is: " + this.height + " and my color is: " + this.leavesColor;
        }
        return "My height is: " + this.height + " and my color is: " + this.leavesColor;
    }
}
