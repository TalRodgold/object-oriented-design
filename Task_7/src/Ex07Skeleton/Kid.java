package Ex07Skeleton;

public class Kid extends Element {
    private int birthYear;
    private Color hairColor;

    public Kid(double width, double height, int birthYear, Color hairColor, String path) {
        super(width, height, path);
        this.birthYear = birthYear;
        this.hairColor = hairColor;
    }

 
    public int getBirthYear() {
        return birthYear;
    }

    public Color getHairColor() {
        return hairColor;
    }
    @Override
    void accept(cVisitor visitor){
        visitor.visit(this);
    }
    @Override
    void accept(taVisitor visitor){visitor.visit(this);}
    @Override
    void accept(spVisitor visitor){
        visitor.visit(this);
    }
    @Override
    void accept(lpVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return "kid";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AMPHIBIAN;
    }

    @Override
    public String toString() {
        return "A kid born in  " + birthYear + "\n";
    }
}
