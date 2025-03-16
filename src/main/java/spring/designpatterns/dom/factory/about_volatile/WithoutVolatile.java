package spring.designpatterns.dom.factory.about_volatile;

/**
 * ✅ 1. volatile 없이 발생하는 문제
 먼저, volatile 없이 실행하면 스레드가 플래그 변경을 감지하지 못할 가능성이 있습니다.

 * 🚨 예상 문제
 * running = false;를 설정했지만 worker 스레드가 루프를 빠져나오지 않을 수도 있음
 * 이유: worker 스레드가 running 값을 CPU 캐시에 저장하고, 메인 메모리의 변경 사항을 보지 못할 수 있음
 */
class WithoutVolatile {
    static boolean running = true; // volatile 없음

    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            while (running) { // 메인 메모리 값을 읽지 못할 수도 있음 (CPU 캐시 문제)
            }
            System.out.println("Worker thread stopped.");
        });

        worker.start();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        running = false; // 변경한 값이 다른 스레드에 즉시 반영되지 않을 수 있음
        System.out.println("Main thread set running = false");
    }
}

