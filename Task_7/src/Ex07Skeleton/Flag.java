package Ex07Skeleton;

public class Flag extends Element {

    Color color;
    int carrierHeight;

    public Flag(double width, double length, Color color, int carrierHeight, String path) {
        super(width, length, path);
        this.color = color;
        this.carrierHeight = carrierHeight;
    }

 
    public Color getColor() {
        return color;
    }

    public int getCarrierHeight() {
        return carrierHeight;
    }

    @Override
    void accept(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return Flag.class.getSimpleName().toLowerCase();
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

    @Override
    public String toString() {
        return "A flag with a height of " + carrierHeight + "\n";
    }
}
