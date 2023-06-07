package Ex07Skeleton;

public class TotalAreaVisitor implements Visitor {

    double totalArea;

    public TotalAreaVisitor() {
        totalArea = 0;
    }

    @Override
    public void visit(Tree tree) {
        totalArea += tree.getWidth() /2 * tree.getLength();
    }

    @Override
    public void visit(Lake lake) {
        totalArea += Math.PI * Math.pow(lake.getLength() / 2, 2);

    }

    @Override
    public void visit(Kid kid) {
        totalArea += kid.getWidth() * (kid.getLength()-kid.getWidth()) + Math.PI * Math.pow(kid.getWidth() / 2, 2);
    }

    @Override
    public void visit(Kite kite) {
        totalArea += kite.getWidth() * kite.getLength() / 2;

    }

    @Override
    public void visit(Island island) {
        totalArea += Math.PI * Math.pow(island.getWidth() / 2, 2);

    }

    @Override
    public void visit(Flag flag) {
        totalArea += flag.getWidth() * flag.getLength();

    }

    @Override
    public void visit(Boat boat) {
        totalArea += boat.getWidth() * (boat.getLength() - boat.getWidth() /2) +
                Math.PI * Math.pow(boat.getWidth() / 2, 2)/2;

    }


}
