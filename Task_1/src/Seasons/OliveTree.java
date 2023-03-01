package Seasons;

public class OliveTree extends Tree {

    private static boolean gives_fruit;

    OliveTree(int height, Season season) {
        // TODO: Implement.
        super(height,season,null);
        gives_fruit = false;
    }

    @Override
    public String toString() {
        return "Olive tree. " + super.TOString();

    }
    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (this.getCurrentSeason()) {
            //TODO: add olives on tree???
            case FALL -> this.height = this.height + 5;
            case WINTER -> this.height = this.height + 5;
            case SPRING -> this.height = this.height + 10;
            case SUMMER -> {
                this.height = this.height + 10;
                gives_fruit = true;
            }
        }        }
}
