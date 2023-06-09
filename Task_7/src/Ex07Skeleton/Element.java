package Ex07Skeleton;

public abstract class Element{
    protected double width;
    protected double length;
    private String path;
    private String name;

    abstract void accept(taVisitor visitor);
    abstract void accept(spVisitor visitor);
    abstract void accept(lpVisitor visitor);
    abstract void accept(cVisitor visitor);


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Element(double width, double length, String path) {
        this.width = width;
        this.length = length;
        this.path= path==null?"":path;
    }


    public String getPath(){
        return path;
    }
    public String getFullName(){
        return path.isEmpty()? getName() : path+"/"+getName();
    }
    public abstract String getName();
    public abstract Habitat getHabitat();

    public void addChildElements(Element element) {
    }


}
