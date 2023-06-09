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
    void accept(cVisitor visitor){
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
