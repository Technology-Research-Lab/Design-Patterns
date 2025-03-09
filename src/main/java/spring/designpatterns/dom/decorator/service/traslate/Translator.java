package spring.designpatterns.dom.decorator.service.traslate;

/**
 * 이름 : 번역자
 * 역할 : 번역 기능
 */
public interface Translator {
    String translate(String text);
    String[] divideText(String text);
}
