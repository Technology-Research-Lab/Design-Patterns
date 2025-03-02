package spring.designpatterns.dom.observer.CarSensor_De;

import java.util.ArrayList;
import java.util.List;

public class CarSensor implements DomSubject{
    private int distance;
    private List<DomObserver> observers;

    public CarSensor() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(DomObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DomObserver observer) {
        observers.remove(observer);
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurement(int distance){
        this.distance = distance;
        measurementsChanged();
    }

    @Override
    public void notifyObservers() {
        for (DomObserver observer : observers) {
            observer.update(distance);
        }
    }
}
