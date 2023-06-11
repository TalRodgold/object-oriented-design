package Ex07Skeleton;

public class PaperDecorator implements Paper {
     private Paper itsPaper;
    PaperDecorator(Paper p){itsPaper = p;}

    @Override
    public String write() { return itsPaper.write();}
}