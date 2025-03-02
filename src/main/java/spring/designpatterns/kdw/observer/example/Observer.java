package spring.designpatterns.kdw.observer.example;

public interface Observer {
    public void update(float temp, float humidity, float pressure);
}