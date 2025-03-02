package spring.designpatterns.kdw.observer.example;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    //weatherData라는 주제 객체를 생성자로 전달하고 디스플레이를 옵저버에 등록
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display(); //update가 호출되면 기온과 습도를 저장하고 display()를 호출
    }

    public void display() {
        System.out.println("Current temperature: " + temperature + "\nCurrent humidity: " + humidity);
    }
}
