package spring.designpatterns.dom.template.beverage;

public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        hook();
    }

    private void hook() {
    }

    abstract void addCondiments();

    abstract void brew();

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    void boilWater() {
        System.out.println("물 끓이는 중");
    }
}
