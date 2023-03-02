package Seasons;

public abstract class Animal implements Seasonable,Comparable{
    protected int weight;
    private Season season;
    protected Color color;

    Animal(int weight, Season season, Color color){
        this.weight =weight;
        this.season =season;
        this.color =color;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        if (this.weight > ((Animal)o).weight){
            return 1;
        }
        return 0;
    }
    @Override
    public void changeSeason(){
        if (this.getCurrentSeason() == Season.FALL){
            this.season = Season.WINTER;
        }
        else if (this.getCurrentSeason() == Season.WINTER){
            this.season = Season.SPRING;
        }
        else if (this.getCurrentSeason() == Season.SPRING){
            this.season = Season.SUMMER;
        }
        else if (this.getCurrentSeason() == Season.SUMMER){
            this.season = Season.FALL;
        }
    }
    @Override
    public String TOString(){
        return "My weight is: " + this.weight + " and my color is: " + this.color;
    }
}
