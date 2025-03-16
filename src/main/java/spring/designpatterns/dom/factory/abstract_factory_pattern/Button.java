package spring.designpatterns.dom.factory.abstract_factory_pattern;

/**
 * ✅ 개념
 * 관련 있는 객체들의 그룹(제품군)을 생성하는 팩토리 패턴
 * 팩토리 인터페이스를 통해 서로 다른 제품군을 일관되게 생성
 * 예: GUI 라이브러리에서 윈도우 스타일과 Mac 스타일 UI 컴포넌트를 각각 생성
 * ✅ 특징
 * 특정 플랫폼 또는 환경에 맞는 연관된 객체들을 세트로 생성할 때 유용
 * 하지만 새로운 제품군을 추가하려면 모든 팩토리를 수정해야 함
 */
// 버튼 인터페이스
interface Button {
    void click();
}

// 윈도우 스타일 버튼
class WindowsButton implements Button {
    public void click() {
        System.out.println("Windows Button Clicked!");
    }
}

// Mac 스타일 버튼
class MacButton implements Button {
    public void click() {
        System.out.println("Mac Button Clicked!");
    }
}

// 체크박스 인터페이스
interface Checkbox {
    void check();
}

// 윈도우 스타일 체크박스
class WindowsCheckbox implements Checkbox {
    public void check() {
        System.out.println("Windows Checkbox Checked!");
    }
}

// Mac 스타일 체크박스
class MacCheckbox implements Checkbox {
    public void check() {
        System.out.println("Mac Checkbox Checked!");
    }
}

// 추상 팩토리
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// 윈도우 팩토리 (윈도우 스타일의 버튼과 체크박스를 생성)
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Mac 팩토리 (Mac 스타일의 버튼과 체크박스를 생성)
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
