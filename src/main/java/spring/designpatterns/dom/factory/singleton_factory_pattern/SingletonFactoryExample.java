package spring.designpatterns.dom.factory.singleton_factory_pattern;

/**
 * ✅ 싱글톤 팩토리 패턴의 장점 & 단점
 * 장점	단점
 * 전역에서 동일한 객체 사용 (일관성 유지)	멀티스레드 환경에서 동기화 필요
 * 객체 생성 비용 절약	클래스 확장 (상속)이 어려움
 * 메모리 절약 (불필요한 객체 생성을 막음)	의존성이 증가할 가능성 있음 (전역 상태 유지)
 *
 * ✅ 싱글톤 팩토리 패턴을 언제 사용할까?
 * 사용 사례	설명
 * 데이터베이스 연결 (DB Connection Pool)	동일한 DB 연결을 여러 곳에서 사용
 * 설정 관리 (Configuration Manager)	설정 값을 전역적으로 유지
 * 로그 시스템 (Logging Service)	하나의 로거 인스턴스를 유지하여 로그 관리
 * 스레드 풀 (Thread Pool)	스레드를 효율적으로 관리
 */
// 사용 예제
public class SingletonFactoryExample {
    public static void main(String[] args) {
        // 싱글톤 팩토리 인스턴스 가져오기
        SingletonFactory factory1 = SingletonFactory.getInstance();
        SingletonFactory factory2 = SingletonFactory.getInstance();

        // 같은 인스턴스인지 확인
        System.out.println(factory1 == factory2); // true (같은 인스턴스)

        // 제품 생성
        Product product = factory1.createProduct();
        product.use(); // 출력: Using Product A
    }
}
