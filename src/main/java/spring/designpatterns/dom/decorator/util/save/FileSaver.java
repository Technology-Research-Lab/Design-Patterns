package spring.designpatterns.dom.decorator.util.save;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import spring.designpatterns.dom.decorator.entity.LanFile;
import spring.designpatterns.dom.decorator.entity.Language;
import spring.designpatterns.dom.decorator.entity.User;
import spring.designpatterns.dom.decorator.entity.User_File;
import spring.designpatterns.dom.decorator.repository.LanFileRepository;
import spring.designpatterns.dom.decorator.repository.UserFileRepository;
import spring.designpatterns.dom.decorator.repository.UserRepository;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * 이름: 파일 저장자
 * 내용: 유저, 파일 등의 정보들을 취합하여, 실제 파일을 생성합니다.
 *      또한 DB에 관련 정보들을 영구 저장하여, 다시 읽어 올 수 있습니다.
 */

@Log4j2
@Component
@RequiredArgsConstructor
public class FileSaver {

    private final String FILE_DIR = "src/main/resources/files/";

    private final LanFileRepository lanFileRepository;
    private final UserRepository userRepository;
    private final UserFileRepository userFileRepository;

    public void saveFile(String loginId, String fileName, String content, int languageType) {
        try {
            String filePath = getFilePath();
            User user = userRepository.findByLoginId(loginId);

            LanFile lanFile = LanFile.builder().fileName(fileName).filePath(filePath).language(getLanguage(languageType)).build();
            lanFile = lanFileRepository.save(lanFile);

            makeFile(filePath, content);

            User_File userFile = new User_File(lanFile.getFileId(), user.getUserId());
            userFileRepository.save(userFile);

        } catch (Exception e) {
            log.error("파일 저장 중 에러가 발생했습니다.");
            e.printStackTrace();
        }
    }
    public void makeFile(String filePath, String content) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath, true));
        fileWriter.write(content);
        fileWriter.flush();

        fileWriter.close();
    }

    public Language getLanguage(int languageType) {
        if (languageType == 1) {
            return Language.ALIEN;
        } else {
            log.error("죄송합니다. 아직 미구현인 단계입니다. \n 1번만 고를 수 있습니다. \n 1번을 골라주세요.");
            throw new RuntimeException();
        }
    }

    public String getFilePath(){
        String uuid = UUID.randomUUID().toString();
        return FILE_DIR + uuid;
    }
}
