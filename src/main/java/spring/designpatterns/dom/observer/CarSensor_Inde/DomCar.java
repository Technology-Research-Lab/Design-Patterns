package spring.designpatterns.dom.observer.CarSensor_Inde;

public class DomCar implements DomObserver, DomReaction {
    private int distance;

    public DomCar() {
    }

    @Override
    public void update(int distance) {
        this.distance = distance;
        reaction();
    }

    @Override
    public void reaction() {
    }
}
