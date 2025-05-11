package spring.designpatterns.dom.proxy;

import static spring.designpatterns.dom.ThreadSleep.sleep;

/**
 * <p>초기화 지연, 접근 제어, 로깅, 캐싱 등 다양하게 응용해 사용 할 수 있다.
 *    데코레이션 패턴 처럼 자기 자신을 참조하게 할 수 있게 구현을 이용해서
 *    필드로 프록시 클래스에서 사용할 실제 인스턴스의 클래스를 가져야 한다.
 *    어뎁터 패턴과의 차이가 바로 이것이다.</p>
 */
public class BaseGameService implements GameService{

    @Override
    public void startGame(){
        sleep(1000L);
        System.out.println("이 자리에 오신 여러분을 진심으로 환영합니다.");
    }

    @Override
    public String toString() {
        return "BaseGameService{}";
    }
}
