package spring.designpatterns.dom.decorator.service.convert;

/**
 * 이름 : 변환자
 * 역할 : 변환 기능
 */
public interface FileConvertor {
    String readFile(String fileName);
}
