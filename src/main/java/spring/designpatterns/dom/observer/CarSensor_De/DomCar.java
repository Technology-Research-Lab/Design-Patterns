package spring.designpatterns.dom.observer.CarSensor_De;

public class DomCar implements DomObserver, DomReaction {
    private int distance;
    private int speed;
    private DomCarBreak domCarBreak;
    private DomCarSound domCarSound;

    public DomCar() {
        this.domCarBreak = new DomCarBreak();
        this.domCarSound = new DomCarSound();
    }

    @Override
    public void update(int distance) {
        this.distance = distance;
        reaction();
    }

    @Override
    public void reaction() {
        if (distance < 10) {
            speed = domCarBreak.stop();
        } else if (distance < 30) {
            speed =  domCarBreak.fastDown(distance, speed);
        } else if (distance < 50) {
            speed = domCarBreak.slowDown(distance, speed);
        }
        domCarSound.reaction(distance);
    }
}
