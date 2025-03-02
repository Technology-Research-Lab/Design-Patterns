package spring.designpatterns.kdw.observer.example.example2;

import java.util.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
