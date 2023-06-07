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
            if (containingElement.getClass().getName().equals("Lake") || containingElement.getClass().getName().equals("Island")){
                if (element.getClass().getName().equals("Flag")){
                    pathToElementMap.remove(element);
                    System.out.println( (containingElement).getName() + " cannot contain flag\n");
                }
                else{
                    this.pathToElementMap.get(element.getPath()).addChildElements(element);
                }
            }
            else{
                this.pathToElementMap.get(element.getPath()).addChildElements(element);
            }
        }
    }


    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }


}
