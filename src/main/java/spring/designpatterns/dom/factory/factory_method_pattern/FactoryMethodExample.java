package spring.designpatterns.dom.factory.factory_method_pattern;

// 사용 예제
public class FactoryMethodExample {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreatorA(); // ConcreteCreatorB로 변경 가능
        Product product = creator.createProduct();
        product.use();
    }
}
