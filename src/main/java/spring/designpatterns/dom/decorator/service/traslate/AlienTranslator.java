package spring.designpatterns.dom.decorator.service.traslate;

import org.springframework.transaction.annotation.Transactional;

/**
 * 이름 : 외계어 번역자
 * 역할 : 통일된 숫자를 외계어로 변환한다.
 */
@Transactional
public class AlienTranslator implements Translator{

    private Translator translate;

    public AlienTranslator(Translator translate) {
        this.translate = translate;
    }

    @Override
    public String translate(String text) {
        return matchWords(divideText(translate.translate(text)));
    }

    public String matchWords(String[] dividedText){
        StringBuilder translatedText = new StringBuilder();
        for(int i = 0; i <dividedText.length; i++){
            if (dividedText[i].equals("1")) {
                translatedText.append("Tibabu");
            }else {
                translatedText.append("쿠랑");
            }if (i != dividedText.length - 1) translatedText.append(" ");
        }
        return translatedText.toString();
    }

    @Override
    public String[] divideText(String text) {
        return text.split(" ");
    }
}
