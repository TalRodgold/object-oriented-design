package Ex07Skeleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
        Map<String, Element> files = new HashMap();

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
                    System.out.println(( root.pathToElementMap).size());
                    break;
                case "sh":
                    for (Entry<String, Element> entry : root.pathToElementMap.entrySet()) {
                        String key = entry.getKey();
                        System.out.println(key);
                    }
                    break;
                case "ta":
                    long total_area = 0;
                    for (Entry<String, Element> entry : root.pathToElementMap.entrySet()) {
                        total_area = (long) (total_area + (entry.getValue().getLength() * entry.getValue().getWidth()));

                        Element computer = entry.getValue();
                        computer.accept(new TotalAreaVisitor());
                        TotalAreaVisitor costVisitor = new TotalAreaVisitor();
                        computer.accept(costVisitor);
                        total_area += costVisitor.totalArea;
                    }
                    System.out.println(total_area);
                    break;
                case "lp":
                    for (Entry<String, Element> entry : root.pathToElementMap.entrySet()) {
                        System.out.println(entry.toString());
                    }

                        //An empty island named Madagascar.
                    // A lake named Grand containing:
                    // A boat made of timber material.
                    // An island named Glover containing:
                    // A tree with an amount of 2500 leaves.
                    // A 10 year old kid with black hair.
                    // A kite of color: red.
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
        // TODO: Add a Paper Factory and use it to create a Paper
        Paper paper = null;
        String choice="";
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
   public static Paper paperElementMenu(Scanner scanner, Paper paper){
        System.out.println("Choose from the following elements:\n" +
                "tb: table\n" +
                "eq: equation\n" +
                "d: diagram\n" +
                "nt: note");
        // TODO: Use a Paper-Element Factory to create a decorated Hamburger
        return null;
    }
}
