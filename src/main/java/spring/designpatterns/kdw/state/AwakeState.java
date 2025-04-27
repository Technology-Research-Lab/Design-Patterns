package spring.designpatterns.kdw.state;

import lombok.Getter;

public class AwakeState implements MentalState {
    @Getter
    private static final AwakeState instance = new AwakeState();

    private AwakeState() {} // 싱글턴

    @Override
    public void study(Person person) {
        System.out.println("공부가 열심히 하는중");
    }

    @Override
    public void refresh(Person person) {
        System.out.println("편안하게 휴식 중.");
    }

    @Override
    public void goToBed(Person person) {
        System.out.println("이제 자야겠다.");
        //수면 상태로 전환
        person.setState(SleepingState.getInstance());
    }

    @Override
    public void move(Person person) {
        System.out.println("뚜벅뚜벅 잘 걸어 댕김.");
    }

    @Override
    public void anyAction(Person person, String action) {
        if ("커피".equals(action)) {
            System.out.println("커피 한 잔 카페인 충전.");

        } else if ("음악".equals(action)) {
            System.out.println("음악 들으면서 기분전환.");

        } else if ("물".equals(action) ||"찬물".equals(action)||"따뜻한물".equals(action)){
            System.out.println("물 한잔 마심.");
        } else{
            System.out.println("'" + action + "' 행동을 하는중");
    }

    }
    @Override
    public String toString() {
        return "일어난 상태(비수면)";
    }
}
