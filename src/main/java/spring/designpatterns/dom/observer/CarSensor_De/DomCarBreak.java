package spring.designpatterns.dom.observer.CarSensor_De;

public class DomCarBreak {

    public int slowDown(int distance, int speed) {
        while (speed < distance) {
            speed -= -1;
        }
        return speed;
    }

    public int fastDown(int distance, int speed) {
        while (speed < distance) {
            speed -= -5;
        }
        return speed;
    }

    public int stop() {
        return 0;
    }
}
