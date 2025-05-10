package spring.designpatterns.kdw.state;

// 수면, 비수면, 비몽사몽
public interface MentalState {

    void study(Person person);

    void refresh(Person person);

    void goToBed(Person person);

    void move(Person person);

    void anyAction(Person person, String action);

    @Override
    String toString(); // 상태 이름을 반환하기 위한 메서드 (디버깅/출력용)
}

