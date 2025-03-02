package spring.designpatterns.kdw.observer.example.example2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@Getter
public class WeatherData extends Observable {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        //자바 내장 옵저버를 사용하면 생성자에서 옵저버들을 저장하기 위한 자료구조 필요X
    }
    //옵저버가 등록되면 맨 뒤에 추가하기만 하면됨
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    //옵저버 탈퇴 신청되면 리스트에서 삭제
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0) {
            observers.remove(i);
        }
    }

    //갱신된 측정치를 받으면 모든 옵저버들한테 알림
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
