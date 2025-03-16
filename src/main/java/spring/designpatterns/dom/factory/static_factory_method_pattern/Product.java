package spring.designpatterns.dom.factory.static_factory_method_pattern;

/**
 * ✅ 개념
 * 객체를 생성할 때 생성자(new)를 직접 호출하는 대신,
 * 정적(static) 메서드를 통해 객체를 반환하는 방식.
 * 대표적인 예:
 * Integer.valueOf(10)
 * List.of(1, 2, 3)
 * ✅ 특징
 * 가독성 향상
 * new Product("A") 대신 Product.createA()로 더 명확하게 표현 가능
 * 객체 생성을 캡슐화
 * 내부적으로 캐싱, 풀링, 서브클래스 반환 등의 로직 추가 가능
 * 생성자의 오버로딩 문제 해결
 * 정적 메서드명을 다르게 하여 가독성을 높일 수 있음
 * 상속을 제한할 수 있음
 * 생성자를 private으로 만들면 하위 클래스 확장이 불가능
 */
// Product 인터페이스
interface Product {
    void use();
}

// ProductA 클래스
class ProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

// ProductB 클래스
class ProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}

// Static Factory Method 패턴 적용
class ProductFactory {

    // 정적 메서드를 통해 객체 생성
    public static Product createProductA() {
        return new ProductA();
    }

    public static Product createProductB() {
        return new ProductB();
    }
}



