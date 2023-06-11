package Ex07Skeleton;

public class TBPaperDecorator extends PaperDecorator{
    public TBPaperDecorator(Paper p){
        super(p);
    }
    @Override
    public String write(){
        return super.write() + " Table";
    }
}
