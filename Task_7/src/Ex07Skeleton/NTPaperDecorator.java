package Ex07Skeleton;

public class NTPaperDecorator extends PaperDecorator {
    public NTPaperDecorator(Paper p){
        super(p);
    }
    @Override
    public String write(){
        return super.write() + " Note";
    }
}
