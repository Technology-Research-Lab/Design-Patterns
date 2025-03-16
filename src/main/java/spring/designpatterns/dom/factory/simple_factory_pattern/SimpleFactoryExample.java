package spring.designpatterns.dom.factory.simple_factory_pattern;

public class SimpleFactoryExample {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        product.use();
    }
}
