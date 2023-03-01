package Seasons;

public class FigTree extends Tree {

    private String leafs;

    FigTree(int height, Season season) {
        super(height,season,season.);
        this.leafs = "";
    }

    @Override
    public String toString() {
        return "Fig tree. " + this.leafs + super.TOString();
    }
    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (this.getCurrentSeason()) {
            //TODO: add leafs on tree???
            case FALL -> {
                this.height = this.height + 20;
                this.leavesColor = Color.YELLOW;
            }
            case WINTER -> {
                this.height = this.height + 20;
                this.leavesColor = null;
            }
            case SPRING -> {
                this.height = this.height + 30;
                this.leavesColor = Color.GREEN;
            }
            case SUMMER -> {
                this.height = this.height + 20;
                this.leafs ="I give fruit. ";
            }
        }
    }
}
