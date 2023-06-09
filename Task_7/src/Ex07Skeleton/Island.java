package Ex07Skeleton;

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
    void add_child(Element e)
    {
        childElements.add(e);
    }
    public void addChildElements(Element e){
        childElements.add(e);
    }
    public List<Element> GetChildElements(){
        return childElements;
    }
    @Override
    void accept(cVisitor visitor){
        for(Element e: childElements)
        {
            e.accept(visitor);
        }
        visitor.visit(this);

    }
    @Override
    void accept(taVisitor visitor){
        for(Element e: childElements)
        {
            e.accept(visitor);
        }
        visitor.visit(this);

    }
    @Override
    void accept(spVisitor visitor)
    {
        visitor.visit(this);
        for(Element e: childElements)
        {
            e.accept(visitor);
        }
    }
    @Override
    void accept(lpVisitor visitor)
    {
        visitor.visit(this);
        for(Element e: childElements)
        {
            e.accept(visitor);
        }
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
