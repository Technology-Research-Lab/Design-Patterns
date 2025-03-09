package spring.designpatterns.dom.decorator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import spring.designpatterns.dom.decorator.service.convert.FileConvertor;
import spring.designpatterns.dom.decorator.service.traslate.AlienTranslator;
import spring.designpatterns.dom.decorator.service.traslate.FileTranslator;
import spring.designpatterns.dom.decorator.service.traslate.Translator;
import spring.designpatterns.dom.decorator.util.output.FileOutput;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
public class AlienTranslatorTest {

    private FileConvertor fileConvertor = new FileOutput();
    private Translator translator = new FileTranslator(fileConvertor);
    private AlienTranslator alienTranslator = new AlienTranslator(translator);

    @Test
    @DisplayName("외계인 번역기 테스트")
    public void testAlienTranslator() {
        //given
        String fileName = "translatorTest.txt";

        //when
        String AlienLanguage = alienTranslator.translate(fileName);

        //then
        Assertions.assertThat(AlienLanguage).isEqualTo("Tibabu Tibabu 쿠랑 쿠랑");

    }
}
