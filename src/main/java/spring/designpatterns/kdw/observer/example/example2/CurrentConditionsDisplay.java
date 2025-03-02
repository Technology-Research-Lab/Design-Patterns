package spring.designpatterns.kdw.observer.example.example2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;
    private Subject weatherData;

    //
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if(arg instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)arg;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }


    public void display() {
        System.out.println("Current temperature: " + temperature + "\nCurrent humidity: " + humidity);
    }
}
