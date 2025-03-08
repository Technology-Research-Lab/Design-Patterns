package spring.designpatterns.dom.decorator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import spring.designpatterns.dom.decorator.entity.LanFile;
import spring.designpatterns.dom.decorator.entity.Language;
import spring.designpatterns.dom.decorator.entity.User;
import spring.designpatterns.dom.decorator.entity.User_File;
import spring.designpatterns.dom.decorator.repository.LanFileRepository;
import spring.designpatterns.dom.decorator.repository.UserFileRepository;
import spring.designpatterns.dom.decorator.repository.UserRepository;
import spring.designpatterns.dom.decorator.util.save.FileSaver;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
public class FileSaverTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanFileRepository lanFileRepository;
    @Autowired
    private UserFileRepository userFileRepository;

    @Test
    public void testSave() {
        //given
        FileSaver fileSaver = new FileSaver(lanFileRepository, userRepository, userFileRepository);
        User user = userRepository.findById(1L).get();

        //when
        fileSaver.saveFile(user.getLoginId(), "Test_file_name", "Test. content, ddasdf", 1);
        User_File userFile = userFileRepository.findById(1L).get();

        LanFile foundFile = lanFileRepository.findById(userFile.getFileId()).get();
        User foundUser = userRepository.findById(userFile.getUserId()).get();

        //then
        Assertions.assertEquals(userFile.getUserFileId(), 1);
        Assertions.assertEquals(userFile.getFileId(), 1);
        Assertions.assertEquals(userFile.getUserId(), 1);

        Assertions.assertEquals(foundFile.getFileName(), "Test_file_name");
        Assertions.assertEquals(foundFile.getLanguageType(), Language.ALIEN);

        Assertions.assertEquals(foundUser.getLoginId(), "test_id");
        Assertions.assertEquals(foundUser.getUserName(), "test_name");
        Assertions.assertEquals(foundUser.getPassword(), "1234");
    }

    @BeforeEach
    public void setUp() {
        User user = makeUser();
        userRepository.save(user);
    }

    public User makeUser(){
        return User.builder()
                .loginId("test_id")
                .userName("test_name")
                .password("1234").build();
    }

    public LanFile makeFile(){
        return LanFile.builder()
                .fileName("test_file")
                .filePath("src/main/resources/files")
                .language(Language.ALIEN).build();
    }

    public User_File makeUserFile(User user, LanFile file){
        return User_File.builder()
                .userId(user.getUserId())
                .fileId(file.getFileId()).build();
    }
}
