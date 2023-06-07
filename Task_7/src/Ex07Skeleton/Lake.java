package Ex07Skeleton;
import java.util.ArrayList;
import java.util.List;

public class Lake extends Element {
    private String name;
    private double diameter;
    private List<Element> childElements;
    public Lake(String name, double diameter, String path) {
        super(diameter,diameter,path);
        this.name = name;
        this.diameter = diameter;
        this.childElements = new ArrayList<>();
    }
    public void addChildElements(Element e){
        childElements.add(e);
    }

    @Override
    void accept(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

    @Override
    public String toString(){
        if (childElements.isEmpty()){
            return "An empty lake named " + name +".";
        }
        String str = "An lake named " + name + " containing:\n";
        for (Element element : childElements) {
            str += element.toString();
        }
        return str;
    }
}
