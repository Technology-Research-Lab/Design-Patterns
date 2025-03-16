package spring.designpatterns.dom.factory.static_factory_method_pattern.other_singleton_patterns;

/**
 * 1. 이른 초기화 (Eager Initialization)
 * 객체를 미리 생성해 두고 사용하는 방식.
 * 멀티스레드 환경에서도 안전하지만, 사용하지 않아도 객체가 생성됨.
 */
class EagerSingletonFactory {
    private static final EagerSingletonFactory instance = new EagerSingletonFactory();

    private EagerSingletonFactory() {}

    public static EagerSingletonFactory getInstance() {
        return instance;
    }

    public Product createProduct() {
        return new ProductA();
    }
}
