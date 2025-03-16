package spring.designpatterns.dom.factory.factory_method_pattern;

/**
 * ✅ 개념
 * 객체 생성을 서브클래스에서 담당하도록 설계하는 패턴
 * 객체 생성을 위한 추상 메서드를 선언하고, 이를 하위 클래스에서 구현
 * GoF 디자인 패턴에 포함됨
 * ✅ 특징
 * 새로운 객체 유형이 추가될 때 서브클래스만 추가하면 됨 (OCP 원칙 준수)
 * 다형성을 활용하여 객체 생성을 캡슐화
 * 그러나 서브클래스가 많아질 수 있음 (복잡성 증가)
 */

// 제품 인터페이스
interface Product {
    void use();
}

// 구체적인 제품 A
class ProductA implements Product {
    public void use() {
        System.out.println("Using ProductA");
    }
}

// 구체적인 제품 B
class ProductB implements Product {
    public void use() {
        System.out.println("Using ProductB");
    }
}

// 팩토리 메소드 패턴 적용: Creator 클래스
abstract class Creator {
    abstract Product createProduct(); // 팩토리 메소드
}

// 구체적인 CreatorA (ProductA를 생성)
class ConcreteCreatorA extends Creator {
    public Product createProduct() {
        return new ProductA();
    }
}

// 구체적인 CreatorB (ProductB를 생성)
class ConcreteCreatorB extends Creator {
    public Product createProduct() {
        return new ProductB();
    }
}
