package spring.designpatterns.dom.factory.abstract_factory_pattern;

// 클라이언트 코드
public class AbstractFactoryExample {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory(); // MacFactory로 변경 가능
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.click();
        checkbox.check();
    }
}
