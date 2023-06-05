package Ex07Skeleton;

public class Boat extends Element{
    Material material;
    public Boat(double width, double length, Material m, String path) {
        super(width, length, path);
        this.material=m;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return "boat";
    }

    @Override
    void accept(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }

    @Override
    public String toString() {
        return "A boat made of " + material + " material.\n";
    }
}
