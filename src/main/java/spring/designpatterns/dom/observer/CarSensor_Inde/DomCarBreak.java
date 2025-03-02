package spring.designpatterns.dom.observer.CarSensor_Inde;

public class DomCarBreak implements DomObserver, DomReaction {
    private int distance;
    private int speed;

    @Override
    public void update(int distance) {
        this.distance = distance;
        reaction();
    }

    @Override
    public void reaction() {
        if (distance < 10) {
            speed = 0;
        }else if (distance < 30) {
            while (speed < distance) {
                speed -= -5;
            }
        }else if (distance < 50) {
            while (speed < distance) {
                speed -= -1;
            }
        }
    }
}
