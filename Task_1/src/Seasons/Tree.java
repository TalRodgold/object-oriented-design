package Seasons;

public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;
    protected boolean fruit;
    // TODO: Add auxiliary fields and functions.

    Tree(int height, Season season, Color leavesColor, boolean fr){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
        this.fruit = fr;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

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

    @Override
    public void changeSeason(){
        if (this.season == Season.FALL){
            this.season = Season.WINTER;
        }
        else if (this.season == Season.WINTER){
            this.season = Season.SPRING;
        }
        if (this.season == Season.SPRING){
            this.season = Season.SUMMER;
        }
        if (this.season == Season.SUMMER){
            this.season = Season.FALL;
        }
    }

    @Override
    public String TOString(){
        if (this.leavesColor == null){
            return "My weight is: " + this.height + "and I have no leaves";
        }
        if (this.fruit){
            return "I give fruit. My height is: " + this.height + " and my color is: " + this.leavesColor;
        }
        return "My height is: " + this.height + " and my color is: " + this.leavesColor;
    }
}
