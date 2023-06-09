package Ex07Skeleton;

public class Tree extends Element {

    int leavesAmount;

    public int getLeavesAmount() {
        return leavesAmount;
    }

    public Tree(double width, double height, int leavesAmount, String path) {
        super(width, height, path);
        this.leavesAmount = leavesAmount;
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
        return "tree";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

    @Override
    public String toString() {
        return "A tree with an amount of " + leavesAmount + " leaves.\n";
    }

}
