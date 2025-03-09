package spring.designpatterns.dom.decorator.service.find;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import spring.designpatterns.dom.decorator.entity.LanFile;
import spring.designpatterns.dom.decorator.entity.User_File;
import spring.designpatterns.dom.decorator.repository.LanFileRepository;
import spring.designpatterns.dom.decorator.repository.UserFileRepository;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class FileFinder implements Finder {

    private List<String> files;
    private UserFileRepository userFileRepository;
    private LanFileRepository lanFileRepository;

    public FileFinder(UserFileRepository userFileRepository, LanFileRepository lanFileRepository) {
        this.userFileRepository = userFileRepository;
        this.lanFileRepository = lanFileRepository;
        files = new ArrayList<>();
    }

    @Override
    public void find(Object userId) {
        try {
            List<User_File> userFiles = userFileRepository.findByUserId((Long) userId);

            for (User_File userFile : userFiles) {
                LanFile lanFile = lanFileRepository.findById(userFile.getFileId()).get();
                files.add(lanFile.getFilePath());
            }
        } catch (Exception e) {
            log.error("유저 Id로 파일을 찾아오는데 실패하였습니다.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getOutcome() {
        return files;
    }
}
