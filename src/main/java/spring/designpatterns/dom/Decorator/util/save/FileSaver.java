package spring.designpatterns.dom.Decorator.util.save;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import spring.designpatterns.dom.Decorator.entity.User;
import spring.designpatterns.dom.Decorator.repository.FileRepository;

@Log4j2
@Component
@RequiredArgsConstructor
public class FileSaver {

    private final FileRepository fileRepository;

    public void save(User user, String content) {
        try {

        } catch (Exception e) {
            log.error("파일 저장 중 에러가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
