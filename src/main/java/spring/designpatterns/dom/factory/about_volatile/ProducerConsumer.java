package spring.designpatterns.dom.factory.about_volatile;

/**
 * ✅ 정리
 * 코드 예제	volatile 없이 문제 발생	volatile 적용 후 해결
 * 스레드 종료 플래그	while (running)이 무한 루프 가능	running = false;가 즉시 반영되어 종료됨
 * 생산자-소비자 패턴	consumer가 hasData 변경을 감지 못할 수도 있음	consumer가 즉시 변경된 데이터를 확인 가능
 * ✔ 멀티스레드 환경에서 volatile을 사용하면 변수의 변경 사항이 모든 스레드에 즉시 반영됨
 * ✔ 그러나 volatile은 원자성을 보장하지 않으므로 복잡한 연산에는 synchronized 또는 Atomic 클래스를 사용해야 함
 */
class ProducerConsumer {
    private static volatile boolean hasData = false; // 공유 상태 변수

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(1000); // 데이터 생성 시간
                hasData = true;
                System.out.println("Producer: Data produced.");
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            while (!hasData) { } // 데이터가 생성될 때까지 기다림
            System.out.println("Consumer: Data consumed.");
        });

        producer.start();
        consumer.start();
    }
}

