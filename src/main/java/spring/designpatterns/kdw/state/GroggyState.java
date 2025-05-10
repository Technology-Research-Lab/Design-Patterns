package spring.designpatterns.kdw.state;

import lombok.Getter;

//비몽사몽 or 잠와서 졸림
public class GroggyState implements MentalState{
    @Getter
    private static final GroggyState instance = new GroggyState();

    private GroggyState() {} // 싱글턴

    @Override
    public void study(Person person) {
        System.out.println("잠 와도 공부는 해야해...");
    }

    @Override
    public void refresh(Person person) {
        System.out.println("커피를 마실까 산책을 갈까...");
    }

    @Override
    public void goToBed(Person person) {
        System.out.println("그냥 잘래..");
        //수면 상태로 전환
        person.setState(SleepingState.getInstance());
    }

    @Override
    public void move(Person person) {
        System.out.println("비틀비틀 걸어감");
    }

    @Override
    public void anyAction(Person person, String action) {
        if ("알람".equals(action) || "찬물".equals(action) ||"세수".equals(action)) {
            System.out.println("잠이 살짝 깸 (" + action + ")");
            //깨어있는 상태로 전환
            person.setState(AwakeState.getInstance());
        } else if ("커피".equals(action)) {
            System.out.println("커피 마셔도 피곤쓰 그래도 좀 낫네.");
            //깨어있는 상태로 전환
            person.setState(AwakeState.getInstance());
        } else {
            System.out.println("멍... ('" + action + "' 자극에 둔감함 잠와서..)");
        }
    }
    @Override
    public String toString() {
        return "비몽사몽";
    }

}
