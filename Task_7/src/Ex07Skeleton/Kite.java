package Ex07Skeleton;

public class Kite extends Element {
    Color color;

    public Kite(double width, double height, Color color, String path) {
        super(width, height, path);
        this.color = color;
    }

     public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    void accept(taVisitor visitor){
        visitor.visit(this);
    }
    @Override
    void accept(spVisitor visitor){
        visitor.visit(this);
    }
    @Override
    void accept(cVisitor visitor){
        visitor.visit(this);
    }
    @Override
    void accept(lpVisitor visitor){
        visitor.visit(this);
    }


    @Override
    public String getName() {
        return "kite";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
    @Override

    public String toString() {
        return "A kite of color: " + color + ".\n";
    }
}
