package spring.designpatterns.dom.factory.static_factory_method_pattern;

// 사용 예제
public class StaticFactoryMethodExample {
    public static void main(String[] args) {
        Product product1 = ProductFactory.createProductA();
        product1.use(); // 출력: Using Product A

        Product product2 = ProductFactory.createProductB();
        product2.use(); // 출력: Using Product B
    }
}