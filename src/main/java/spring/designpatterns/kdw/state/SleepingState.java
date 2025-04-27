package spring.designpatterns.kdw.state;

import lombok.Getter;

public class SleepingState implements MentalState{
    @Getter
    private static final SleepingState instance = new SleepingState();

    private SleepingState() {} // 싱글턴

    @Override
    public void study(Person person) {
        System.out.println("자면서 공부 하기는 힘들지요..");
    }

    @Override
    public void refresh(Person person) {
        System.out.println("계속 자는 것이 재충전..");
    }

    @Override
    public void goToBed(Person person) {
        System.out.println("이미 자고 있습니다.");
    }

    @Override
    public void move(Person person) {
        System.out.println("자면서 움직일 수 없습니다. (몽유병 제외)");
    }

    @Override
    public void anyAction(Person person, String action) {
        if ("알람".equals(action)) {
            System.out.println("잠에서 깨어난다 드디어 공부하러..");
            //비몽사몽 상태로 전환
            person.setState(GroggyState.getInstance());
        } else {
            System.out.println("자는중이라 ..(" + action + " 자극에 반응 없음)");

        }
    }
    @Override
    public String toString() {
        return "수면상태";
    }

}
