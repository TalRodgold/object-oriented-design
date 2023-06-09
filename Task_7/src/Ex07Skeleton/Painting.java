package Ex07Skeleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;
    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }
    public void addElement(Element element){
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()){
            elementList.add(element);
        }
        else {
            Element containingElement = pathToElementMap.get(element.getPath());
            if (containingElement.getClass().getName().equals("Lake") && element.getClass().getName().equals("Flag")){
                    System.out.println( (containingElement).getName() + " cannot contain flag\n");
                }
                else if(containingElement.getClass().getName().equals("Lake"))
                {
                    ((Lake)containingElement).add_child(element);
                }
                else if(containingElement.getClass().getName().equals("Island"))
                {
                    ((Island)containingElement).add_child(element);
                }
            }
        }



    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }


}
