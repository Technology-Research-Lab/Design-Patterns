package spring.designpatterns.dom.adaptor.duck;

public class MaxillaryDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quack quack ");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
