package Ex07Skeleton;

public class cVisitor implements C_Visitor {

    private int count = 0;

    public int getCVisitor() {return count;}

    @Override
    public void visit(Tree tree) {count += 1;}

    @Override
    public void visit(Lake lake) {count += 1;}

    @Override
    public void visit(Kid kid) {count += 1;}

    @Override
    public void visit(Kite kite) {count += 1;}

    @Override
    public void visit(Island island) {count += 1;}

    @Override
    public void visit(Flag flag) {count += 1;}

    @Override
    public void visit(Boat boat) {count += 1;}


}
