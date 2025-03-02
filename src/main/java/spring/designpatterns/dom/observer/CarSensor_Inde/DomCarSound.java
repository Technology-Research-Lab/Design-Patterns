package spring.designpatterns.dom.observer.CarSensor_Inde;

public class DomCarSound implements DomObserver, DomReaction{
    private int distance;

    @Override
    public void update(int distance) {
        this.distance = distance;
        reaction();
    }

    @Override
    public void reaction() {
        if (distance < 10) {
            System.out.println("물체가 10m 이내에 존재해 차를 멈춥니다.");
            System.out.println("시동이 꺼집니다.");
        } else if (distance < 30) {
            System.out.println("브레이크를 강하게 밟습니다.");
        } else if (distance < 50) {
            System.out.println("브레이크를 천천히 밟습니다.");
        } else System.out.println("차가 주행중 입니다.");
    }
}
