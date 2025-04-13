package spring.designpatterns.dom.template.hollywood;

/**
 * 할리우드 원칙
 * : 상위클래스에서 실행을 제어함
 * -> 옵저버패턴도 동일함
 * -> 하위는 구현만 사용하는 건 상위에서 결정
 */
// 상위 클래스: 프레임워크 같은 역할
abstract class Game {
    public final void play() {
        initialize();
        start();
        end();
    }

    protected void initialize() {
        System.out.println("게임 준비 중...");
    }

    // 하위 클래스가 반드시 구현해야 할 부분
    protected abstract void start();

    protected void end() {
        System.out.println("게임 종료!");
    }
}

// 하위 클래스: 사용자 정의 게임
class MyGame extends Game {
    @Override
    protected void start() {
        System.out.println("나만의 게임이 시작됩니다!");
    }
}

// 실행 부분 (main 함수)
public class Main {
    public static void main(String[] args) {
        Game game = new MyGame();
        game.play();
    }
}
