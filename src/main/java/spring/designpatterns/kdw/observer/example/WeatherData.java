package spring.designpatterns.kdw.observer.example;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
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
    //상태에대해 모든 옵저버들에게 알려주는 메서드
    public void notifyObservers() {
        for(int i = 0; i<observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }
    //갱신된 측정치를 받으면 모든 옵저버들한테 알림
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
