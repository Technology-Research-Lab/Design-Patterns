package spring.designpatterns.dom.decorator.util.output;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import spring.designpatterns.dom.decorator.service.convert.FileConvertor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 이름 : 언어 통일 번역자
 * 역할 : 언어를 감지하여 숫자로 변환한다.
 */

@Component
@Log4j2
public class FileOutput implements FileConvertor {

    @Override
    public String readFile(String fileName) {
        File file = loadFile(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            fileReader.close();
            br.close();

            return sb.toString();
        }catch(IOException e) {
            log.error("파일을 읽기가 실패하였습니다.\n 파일 이름을 확인해주세요");
            e.printStackTrace();
        }
        return "파일을 읽어오는데 실패하였습니다.";
    }

    public File loadFile(String fileName){
        return new File("src/main/resources/files/" + fileName);
    }

}
