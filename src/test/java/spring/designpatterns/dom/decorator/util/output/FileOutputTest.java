package spring.designpatterns.dom.decorator.util.output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
public class FileOutputTest {

    @Autowired
    private FileOutput fileOutput;

    @Test
    @DisplayName("파일 경로로 파일찾아서 읽는 로직")
    public void outputTest() {
        //given
        String fileName = "txt.txt";

        //then
        String result = fileOutput.readFile(fileName);

        //when
        Assertions.assertFalse(result.isEmpty());
        System.out.println("파일읽기 결과: " + result);
    }
}
