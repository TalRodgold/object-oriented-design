package Seasons;

/**
 * The Animal class represents an abstract animal, which has a weight, a color,
 * and can be affected by seasonal changes.
 */
public abstract class Animal implements Seasonable, Comparable {

    protected int weight;
    private Season season;
    protected Color color;

    /**
     * Creates a new Animal with the given weight, season, and color.
     *
     * @param weight the weight of the animal.
     * @param season the current season of the animal.
     * @param color  the color of the animal.
     */
    Animal(int weight, Season season, Color color) {
        this.weight = weight;
        this.season = season;
        this.color = color;
    }

    /**
     * Gets the current season of the animal.
     *
     * @return the current season of the animal.
     */
    @Override
    public Season getCurrentSeason() {
        return season;
    }

    /**
     * Compares this Animal with the specified object for order. Returns a
     * negative integer, zero, or a positive integer as this Animal is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this Animal
     *         is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        if (this.weight > ((Animal) o).weight) {
            return 1;
        } else if (this.weight < ((Animal) o).weight) {
            return -1;
        }
        return 0;
    }

    /**
     * Changes the season of the animal according to the standard seasonal
     * cycle of FALL, WINTER, SPRING, SUMMER.
     */
    @Override
    public void changeSeason() {
        if (this.getCurrentSeason() == Season.FALL) {
            this.season = Season.WINTER;
        } else if (this.getCurrentSeason() == Season.WINTER) {
            this.season = Season.SPRING;
        } else if (this.getCurrentSeason() == Season.SPRING) {
            this.season = Season.SUMMER;
        } else if (this.getCurrentSeason() == Season.SUMMER) {
            this.season = Season.FALL;
        }
    }

    /**
     * Returns a string representation of this Animal.
     *
     * @return a string representation of this Animal.
     */
    @Override
    public String TOString() {
        return "My weight is: " + this.weight + " and my color is: " + this.color;
    }
}
