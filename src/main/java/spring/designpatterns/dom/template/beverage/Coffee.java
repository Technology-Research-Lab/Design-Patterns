package spring.designpatterns.dom.template.beverage;

public class Coffee extends CaffeineBeverage {

    @Override
    void addCondiments(){
        System.out.println("설탕과 우유 추가하기");
    }

    @Override
    void brew() {
        System.out.println("필터에 커피 거르기");
    }
}
