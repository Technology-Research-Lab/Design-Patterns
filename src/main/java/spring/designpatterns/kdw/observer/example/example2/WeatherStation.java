package spring.designpatterns.kdw.observer.example.example2;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(); //weatherData 객체 생성

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(80, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

    }
}
