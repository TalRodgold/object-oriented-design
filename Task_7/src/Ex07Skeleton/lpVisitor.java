package Ex07Skeleton;
public class lpVisitor implements LP_Visitor{
    int YEAR = 2023;
    @Override
    public void visit(Tree tree) {System.out.print("A tree with an amount of " + tree.getLeavesAmount() + " leaves. ");}

    @Override
    public void visit(Lake lake) {
        if (lake.GetChildElements().isEmpty()) {
            System.out.print("An empty lake named " + lake.getName() + ". ");
        } else {
            System.out.print("A lake named " + lake.getName() + " containing: ");

        }
    }

    @Override
    public void visit(Kid kid) {System.out.print("A " + (YEAR - kid.getBirthYear()) + " year old kid with " + kid.getHairColor().toString().toLowerCase() + " hair. ");}

    @Override
    public void visit(Kite kite) {System.out.print("A kite of color: " + kite.getColor().toString().toLowerCase() + ". ");}

    @Override
    public void visit(Island island) {
        if (island.GetChildElements().isEmpty()) {
            System.out.print("An empty island named " + island.getName() + ". ");
        } else {
            System.out.print("An island named " + island.getName() + " containing: ");

        }
    }

    @Override
    public void visit(Flag flag) {System.out.print("A flag with color: " + flag.getColor().toString().toLowerCase() + " of height " + flag.getCarrierHeight() + ". ");}

    @Override
    public void visit(Boat boat) {System.out.print("A boat made of " + boat.getMaterial().toString().toLowerCase() + " material. ");}
}
