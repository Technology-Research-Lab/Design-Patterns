package spring.designpatterns.dom.template.beverage;

public abstract class CaffeineBeverageWithHook {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()){
            addCondiments();
        }
    }

    /**
     * 오버라이드 가능한 후크임
     * 기본 return은 true이고 false 혹은 조건을 넣어서 return 시켜도 가능하다.
     * @return true;
     */
    public boolean customerWantsCondiments() {
        return true;
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
