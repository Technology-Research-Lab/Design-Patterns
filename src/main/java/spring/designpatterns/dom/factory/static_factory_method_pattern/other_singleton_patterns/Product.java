package spring.designpatterns.dom.factory.static_factory_method_pattern.other_singleton_patterns;

public class Product {
    public void use(){};
}
class ProductA extends Product{
    public void use(){
        System.out.println("Product A");
    };
}
