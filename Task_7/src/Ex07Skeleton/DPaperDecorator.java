package Ex07Skeleton;

public class DPaperDecorator extends PaperDecorator{
    public DPaperDecorator(Paper p){
        super(p);
    }
    @Override
    public String write(){
        return super.write() + " Diagram";
    }
}
