package spring.designpatterns.dom.decorator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import spring.designpatterns.dom.decorator.service.convert.FileConvertor;
import spring.designpatterns.dom.decorator.service.traslate.FileTranslator;
import spring.designpatterns.dom.decorator.util.output.FileOutput;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
public class FileTranslatorTest {

    private FileConvertor fileConvertor = new FileOutput();
    private FileTranslator fileTranslator = new FileTranslator(fileConvertor);

    @Test
    @DisplayName("텍스트 공통숫자로 번역 테스트")
    public void testFileTranslator(){
        //given
        String TextFileName = "translatorTest.txt";

        //when
        String translatedText = fileTranslator.translate(TextFileName);

        //then
        Assertions.assertThat(translatedText).isEqualTo("1 1 -1 -1");

    }
}
