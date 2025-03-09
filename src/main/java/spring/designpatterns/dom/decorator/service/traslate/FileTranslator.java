package spring.designpatterns.dom.decorator.service.traslate;

import org.springframework.transaction.annotation.Transactional;
import spring.designpatterns.dom.decorator.service.convert.FileConvertor;

/**
 * 이름 : 언어 통일 번역자
 * 역할 : 언어를 감지하여 숫자로 변환한다.
 */
@Transactional
public class FileTranslator implements Translator {

    /**
     * (중요)fileConvertor으로 되어있지만, 구현체인 FileOutput을 입력!
     */
    public FileConvertor fileConvertor;

    public FileTranslator(FileConvertor fileConvertor) {
        this.fileConvertor = fileConvertor;
    }

    @Override
    public String translate(String fileName) {
        return matchWords(divideText(fileConvertor.readFile(fileName)));
    }

    /**
     * 다양한 종류의 언어를 공통된 숫자로 바꿉니다ㅏ.
     * 안녕 = 1
     * 모르는 단어 = -1
     */
    public String matchWords(String[] dividedText){
        StringBuilder translatedText = new StringBuilder();
        for(int i = 0; i <dividedText.length; i++){
            if (dividedText[i].equals("안녕")||dividedText[i].equals("Hello")) {
                translatedText.append("1");
            }else {
                translatedText.append("-1");
            }if (i != dividedText.length - 1) translatedText.append(" ");
        }
        return translatedText.toString();
    }

    public String[] divideText(String text) {
        return text.split(" ");
    }

}
