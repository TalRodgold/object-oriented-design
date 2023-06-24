package WS1.Observables;

import WS1.Observers.Observer;

import java.util.LinkedList;
import java.util.List;

public class Observable<T> {
    private List<Observer<T>> observers = new LinkedList<>();

    public void notifyObservers(T t){
        for(Observer ob : observers){
            ob.update(t);
        }
    }

    public void addObserver(Observer<T> o){
        observers.add(o);
    }
}
