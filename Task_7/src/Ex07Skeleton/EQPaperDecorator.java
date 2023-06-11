package Ex07Skeleton;

public class EQPaperDecorator extends PaperDecorator {
    public EQPaperDecorator(Paper p){
        super(p);
    }
    @Override
    public String write(){
        return super.write() + " Equation";
    }
}
