package spring.designpatterns.dom.factory.about_volatile;

/**
 * 스레드는 병렬적으로 실행되어 동시에 Consumer와 prosucer가 실행된다.
 * -> producer가 먼저 실행되었어도, consumer가 콘솔창에 먼저 나타날 수 있다.
 *
 *  join()을 사용하면, producer가 끝난 후에 consumer가 실행될 수 있도록 순서를 제어할 수 있다.
 */
class OrderedExecution {
    private static volatile boolean hasData = false;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(1000);
                hasData = true;
                System.out.println("Producer: Data produced.");
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            while (!hasData) { }
            System.out.println("Consumer: Data consumed.");
        });

        producer.start();

        try {
            producer.join(); // 🔹 `producer`가 끝날 때까지 기다림
        } catch (InterruptedException e) {}

        consumer.start(); // 🔹 `consumer`가 반드시 `producer` 실행 후 실행됨
    }
}

