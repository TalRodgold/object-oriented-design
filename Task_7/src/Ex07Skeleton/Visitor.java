package Ex07Skeleton;

// Visitor interface
public interface Visitor {
    void visit(Kite kite);
    void visit(Boat boat);
    void visit(Flag flag);
    void visit(Tree tree);
    void visit(Kid kid);
    void visit(Lake lake);
    void visit(Island island);
}