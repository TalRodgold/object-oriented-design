package Ex07Skeleton;// TODO: Implement Composite (change this file).

import java.util.ArrayList;
import java.util.List;

public class Island extends Element {
    private String name;
    private double diameter;
    private List<Element> childElements;
    public Island(String name, double diameter, String path) {
        super(diameter,diameter,path);
        this.name = name;
        this.diameter = diameter;
        this.childElements = new ArrayList<>();
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
        return Habitat.AQUATIC;
    }

    @Override
    public String toString(){
        if (childElements.isEmpty()){
            return "An empty island named " + name +".";
        }
        String str = "An island named " + name + " containing:\n";
        for (Element element : childElements) {
            str += element.toString();
        }
        return str;
    }
}
