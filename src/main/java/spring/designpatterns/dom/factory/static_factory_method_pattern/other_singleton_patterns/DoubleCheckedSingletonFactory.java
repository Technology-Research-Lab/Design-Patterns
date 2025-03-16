package spring.designpatterns.dom.factory.static_factory_method_pattern.other_singleton_patterns;

/**
 * 2. 더블 체크 락킹 (Double-Checked Locking)
 * 동기화 비용을 줄이면서 멀티스레드 환경에서도 안전하게 싱글톤을 보장하는 방식.
 */
class DoubleCheckedSingletonFactory {
    private static volatile DoubleCheckedSingletonFactory instance;

    private DoubleCheckedSingletonFactory() {}

    public static DoubleCheckedSingletonFactory getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingletonFactory.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingletonFactory();
                }
            }
        }
        return instance;
    }

    public Product createProduct() {
        return new ProductA();
    }
}
