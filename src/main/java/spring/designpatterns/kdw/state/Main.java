package spring.designpatterns.kdw.state;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.reportStatus();

        // 시나리오
        person.study();          // 공부함
        person.refresh();         // 공부 -> 휴식
        person.goToBed();       // 깨어있음 -> 수면 상태로 전환

        person.study();          // 수면 중 -> 공부 못함
        person.anyAction("조용한 음악"); // 수면 중 -> 반응 없음
        person.anyAction("알람"); // 수면 중 -> 비몽사몽 상태로 전환

        person.study();          // 비몽사몽 -> 잠와도 꾸역꾸역
        person.anyAction("커피"); // 비몽사몽 -> 깨어있는 상태로 전환

        person.study();          // 깨어있음 -> 공부함
        person.goToBed();       // 깨어있음 -> 수면 상태로 전환
        person.anyAction("알람"); // 수면 중 -> 비몽사몽 상태로 전환
        person.anyAction("찬물"); // 물한잔
        person.goToBed();       // 비몽사몽 -> 수면 상태로 전환
    }
}