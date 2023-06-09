package Ex07Skeleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "p: Papers");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }
    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();

        Files.lines(Paths.get(path))
            .map(str -> ElementDetailsFactory.getPaintingElement(str))
            .forEach(e-> painting.addElement(e));
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path=scanner.nextLine();
        Painting root= readElementDetails(path);
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    int counter = 0;
                    for(Element e: root.elementList)
                    {
                        cVisitor c = new cVisitor();
                        e.accept(c);
                        counter += c.getCVisitor();
                    }
                    System.out.println(counter);
                    break;
                case "sh":
                    spVisitor sp = new spVisitor();
                    for(Element e: root.elementList)
                    {
                        e.accept(sp);
                    }
                    break;
                case "ta":
                    taVisitor ta = new taVisitor();
                    for(Element e: root.elementList)
                    {
                        e.accept(ta);
                    }
                    System.out.println(Math.round(ta.totalArea));
                    break;
                case "lp":
                    lpVisitor lp = new lpVisitor();
                    for(Element e: root.elementList)
                    {
                        e.accept(lp);
                    }
                    System.out.println();
                    break;
            }

        }
    }

    public static void paperMenu(Scanner scanner){
        System.out.println("Choose from the following paper:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "pr: journal article\n" +
                "bk: book");

        String choice = scanner.nextLine();
        pFactory pf = new pFactory();
        Paper paper = pFactory.create_paper(choice);

        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());

            }
        }


    }
   public static Paper paperElementMenu(Scanner scanner, Paper paper) {
       System.out.println("Choose from the following elements:\n" +
               "tb: table\n" +
               "eq: equation\n" +
               "d: diagram\n" +
               "nt: note");
       String user_input = scanner.nextLine();
       switch (user_input){
           case "tb":
               paper = new TBPaperDeco(paper);
               break;
           case "eq":
               paper = new EQPaperDeco(paper);
               break;
           case "d":
               paper = new DPaperDeco(paper);
               break;
           case "nt":
               paper = new NTPaperDeco(paper);
               break;
       }
       return paper;
   }

}
