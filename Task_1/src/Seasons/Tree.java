package Seasons;

public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;
    // TODO: Add auxiliary fields and functions.

    Tree(int height, Season season, Color leavesColor){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
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
        return 0;
    }

    @Override
    public void changeSeason(){
        switch (this.season){
            case FALL -> {this.season = Season.WINTER;}
            case WINTER -> {this.season = Season.SPRING;}
            case SPRING -> {this.season = Season.SUMMER;}
            case SUMMER -> {this.season = Season.FALL;}
        }
    }

    @Override
    public String TOString(){
        if (this.leavesColor == null){
            return "My weight is: " + this.height + "and I have no leaves";
        }
        return "My weight is: " + this.height + " and my color is: " + this.leavesColor;
    }
}
