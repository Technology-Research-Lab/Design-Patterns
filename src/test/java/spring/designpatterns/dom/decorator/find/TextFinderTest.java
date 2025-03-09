package spring.designpatterns.dom.decorator.find;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import spring.designpatterns.dom.decorator.entity.LanFile;
import spring.designpatterns.dom.decorator.entity.User;
import spring.designpatterns.dom.decorator.entity.User_File;
import spring.designpatterns.dom.decorator.repository.LanFileRepository;
import spring.designpatterns.dom.decorator.repository.UserFileRepository;
import spring.designpatterns.dom.decorator.repository.UserRepository;
import spring.designpatterns.dom.decorator.service.find.TextFinder;

import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
public class TextFinderTest {

    @Autowired
    private UserFileRepository userFileRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanFileRepository lanFileRepository;


    @Autowired
    private TextFinder textFinder;

    @Test
    @DisplayName("userId로 사용자 이력 불러오는 테스트")
    public void textFinderTest() {
        //given
        Long userId = 1L;
        textFinder.find(userId);

        //when
        Object outcome = textFinder.getOutcome();
        List<String> result = (List<String>)outcome;

        //then
        Assertions.assertThat(result).isNotEmpty();
    }

    @BeforeEach
    public void setUp() {
        User user = makeUser();
        LanFile lanFile = makeFile();
        userRepository.save(user);
        lanFileRepository.save(lanFile);
        User_File userFile = makeUserFile(user, lanFile);
        userFileRepository.save(userFile);
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
                .filePath("src/main/resources/files/txt.txt")
                .language("ALIEN").build();
    }

    public User_File makeUserFile(User user, LanFile file){
        return User_File.builder()
                .userId(user.getUserId())
                .fileId(file.getFileId()).build();
    }
}
