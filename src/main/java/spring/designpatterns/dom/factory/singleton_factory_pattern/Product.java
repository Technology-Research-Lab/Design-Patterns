package spring.designpatterns.dom.factory.singleton_factory_pattern;

/**
 * ✅ 개념
 * 싱글톤 패턴과 팩토리 패턴을 결합한 패턴
 * 객체 생성을 팩토리 메서드를 통해 수행하면서 하나의 인스턴스만 유지
 * 보통 객체 생성 비용이 크거나, 전역 상태가 필요한 경우에 사용
 *
 * ✅ 특징
 * 특징	설명
 * 전역에서 하나의 인스턴스만 유지	여러 곳에서 동일한 객체를 사용
 * 객체 생성을 캡슐화	클라이언트가 직접 객체를 생성하지 않고 팩토리 메서드 사용
 * 불필요한 인스턴스 생성을 방지	성능 최적화 (메모리 절약, 불필요한 객체 생성 방지)
 */
// Product 인터페이스
interface Product {
    void use();
}

// 실제 구현 클래스
class ProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

// Singleton Factory 클래스
class SingletonFactory {
    // 단 하나의 인스턴스를 저장할 변수
    private static SingletonFactory instance;

    // 생성자를 private으로 선언 → 외부에서 new 사용 불가
    private SingletonFactory() {}

    // 스레드 안전한 싱글톤 인스턴스 반환
    public static synchronized SingletonFactory getInstance() {
        if (instance == null) {
            instance = new SingletonFactory();
        }
        return instance;
    }

    // 팩토리 메서드: 객체 생성
    public Product createProduct() {
        return new ProductA();
    }
}


