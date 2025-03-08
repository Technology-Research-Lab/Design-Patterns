package spring.designpatterns.dom.observer.CarSensor_Inde;

import java.util.Scanner;

public class Road {
    public static void main(String[] args) {
        CarSensor sensor = new CarSensor();

        DomCarBreak carBreak = new DomCarBreak();
        DomCarSound carSound = new DomCarSound();
        DomCar domCar = new DomCar();

        sensor.addObserver(domCar);
        sensor.addObserver(carSound);
        sensor.addObserver(carBreak);

        Scanner sc = new Scanner(System.in);

        while (true) {
            int distance = sc.nextInt();
            sensor.setMeasurement(distance);
            if (distance < 10) break;
        }
        System.out.println("쿵 푸쉬쉬~");
        System.out.println("연기가 피어오른다..");
    }
}
