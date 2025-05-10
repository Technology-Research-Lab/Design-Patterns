##  State Pattern: 사람의 정신 상태 변화 구현(예제 변형)

### 1. 상태패턴 개요
**State Pattern**은 객체의 내부 상태가 변경됨에 따라 객체의 행동을 변경할 수 있게 해주는 행위 디자인 패턴이다. 객체가 특정 상태일 때 특정 행동을 하고, 다른 상태일 때는 다른 행동을 하도록 만든다. 마치 객체의 클래스가 바뀌는 것처럼 보임

이 패턴을 사용하면 `if` 또는 `switch` 문으로 상태에 따른 행동을 분기하는 복잡한 코드를 줄이고, 각 상태를 별도의 클래스로 캡슐화하여 코드를 더 깔끔하고 유지보수하기 쉽게 만들 수 있다.
각각의 상태를 독립된 클래스로 만들어 캡슐화하는 데 있다.

상태에 따라 수시로 변하는 복잡한 행동 로직을 지저분한 조건문으로 처리하는 대신에 각각의 상태를 하나의 독립된 객체로 정의하고, 필요할 때마다 이 상태 객체들을 서로 바꿔 끼우는 방식이다. 이를 통해 코드의 유연성과 확장성을 좋게하고 유지보수성을 향상 시킨다.

### 2. 상태패턴 구현
이 예제에서는 사람의 정신 상태(깨어있는 상태, 수면 상태, 비몽사몽 상태)에 따라 다른 행동을 하는 모델을 구현했다.

### 3. 구조
- MentalState: 상태의 인터페이스
- AwakeState: 깨어있는 상태 구현
- SleepingState: 수면 상태 구현
- GroggyState: 비몽사몽 상태 구현
- Person: 상태를 가지는 컨텍스트 객체
- Main: 테스트 시나리오

### 4. 핵심 코드
**`Person.java` (상태 관리 및 위임):**
```java
public class Person {
    private MentalState currentState;

    public Person() {
        this.currentState = AwakeState.getInstance(); // 초기 상태는 깨어있도록 설정
    }

    public void setState(MentalState newState) {
        System.out.println("- 상태 변경: " + this.currentState + " -> " + newState);
        this.currentState = newState;
    }

    public void study() {
        currentState.study(this); // 현재 상태에 행동 위임하는 부분
        //currentState에 담겨있는 객체에서 행동을 취함
    }
}
```
**`AwakeState.java` (상태에 따른 행동 및 상태 전환 예시):**
```java

public class AwakeState implements MentalState {

    @Override  // Person 객체가 AwakeState일 때 호출됨
    public void study(Person person) {
        System.out.println("공부 열심히 하는중");
    }
    @Override
    public void goToBed(Person person) {
        System.out.println("이제 자야겠다.");
        person.setState(SleepingState.getInstance()); // SleepingState로 상태 변경
    }
}
```