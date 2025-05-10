package spring.designpatterns.kdw.state;

public class Person {

    private MentalState currentState; // 현재 정신 상태

    public Person() {
        // 초기 상태는 깨어있는 상태
        this.currentState = AwakeState.getInstance();
        System.out.println("사람 객체 생성됨. 초기 상태: " + currentState);
    }

    public void setState(MentalState newState) {
        System.out.println("- 상태 변경: " + this.currentState + " -> " + newState);
        this.currentState = newState;
    }

    public void study() {
        System.out.println("\n[Action: 공부하기 시도]");
        currentState.study(this);
        reportStatus();
    }

    public void refresh() {
        System.out.println("\n[Action: 재충전 시도]");
        currentState.refresh(this);
        reportStatus();
    }

    public void anyAction(String action) {
        System.out.println("\n[Action: 행동 취함 - '" + action + "']");
        currentState.anyAction(this, action);
        reportStatus();
    }

    public void goToBed() {
        System.out.println("\n[Action: 잠자리에 들기 시도]");
        currentState.goToBed(this);
        reportStatus();
    }

    // 현재 상태 출력 (테스트용)
    public void reportStatus() {
        System.out.println(">> 현재 상태: " + currentState);
    }
}


