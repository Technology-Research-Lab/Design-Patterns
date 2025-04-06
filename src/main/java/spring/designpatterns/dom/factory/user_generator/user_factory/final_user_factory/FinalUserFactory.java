package spring.designpatterns.dom.factory.user_generator.user_factory.final_user_factory;

import lombok.RequiredArgsConstructor;
import spring.designpatterns.dom.factory.user_generator.entity.Auth;
import spring.designpatterns.dom.factory.user_generator.entity.Role;
import spring.designpatterns.dom.factory.user_generator.entity.UserFactory;
import spring.designpatterns.dom.factory.user_generator.repository.*;
import spring.designpatterns.dom.factory.user_generator.user_factory.auths.AdminAuths;
import spring.designpatterns.dom.factory.user_generator.user_factory.auths.Auths;
import spring.designpatterns.dom.factory.user_generator.user_factory.auths.PrimitiveAuths;
import spring.designpatterns.dom.factory.user_generator.user_factory.auths.noramlAuths;
import spring.designpatterns.dom.factory.user_generator.user_factory.members.Administer;
import spring.designpatterns.dom.factory.user_generator.user_factory.members.Members;
import spring.designpatterns.dom.factory.user_generator.user_factory.members.NormalUser;
import spring.designpatterns.dom.factory.user_generator.user_factory.members.PrimitiveUser;

import java.util.List;

@RequiredArgsConstructor
public class FinalUserFactory {

    UserFactoryRepository userFactoryRepository;
    AuthRepository authRepository;
    RoleRepository roleRepository;
    UserAuthRepository userAuthRepository;
    UserRoleRepository userRoleRepository;

    private String username;
    private String password;
    private String role;

    public FinalUserFactory(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void getNormalUser() {
        Members member = new NormalUser();
        Auths auths = new noramlAuths();

        List<UserFactory> userFactory =  member.createUserFactory(username, password, role);
        Auth auth = auths.createAuth();

        userFactoryRepository.saveAll(userFactory);
//        userRoleRepository.save();
//        userAuthRepository.save();
        
        System.out.println("일반 유저를 생산하였습니다.");
    }

    public void getPrimitiveUser() {
        Members member = new PrimitiveUser();
        Auths auths = new PrimitiveAuths();

        List<UserFactory> userFactory =  member.createUserFactory(username, password, role);
        Auth auth = auths.createAuth();

        System.out.println("일반 유저를 생산하였습니다.");
    }

    public void getAdminister() {
        Members member = new Administer();
        Auths auths = new AdminAuths();

        List<UserFactory> userFactory =  member.createUserFactory(username, password, role);
        Auth auth = auths.createAuth();

        System.out.println("일반 유저를 생산하였습니다.");
    }

}
