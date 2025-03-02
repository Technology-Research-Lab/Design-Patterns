package spring.designpatterns.dom.observer.CarSensor_Inde;

public interface DomSubject {
    void addObserver(DomObserver observer);
    void removeObserver(DomObserver observer);
    void notifyObservers();
}
