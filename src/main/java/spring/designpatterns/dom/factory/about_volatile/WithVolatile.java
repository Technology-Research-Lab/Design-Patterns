package spring.designpatterns.dom.factory.about_volatile;

/**
 * ✅ 2. volatile을 추가하여 해결
 * 이제 volatile을 추가하면 모든 스레드가 항상 최신 값을 읽도록 보장됩니다.
 *
 * running = false;가 즉시 반영되어 worker 스레드가 while 루프를 종료함
 */
class WithVolatile {
    private static volatile boolean running = true; // volatile 추가

    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            while (running) { // running 값이 변경되면 즉시 반영됨
            }
            System.out.println("Worker thread stopped.");
        });

        worker.start();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        running = false; // 모든 스레드가 변경된 값을 즉시 반영
        System.out.println("Main thread set running = false");
    }
}

