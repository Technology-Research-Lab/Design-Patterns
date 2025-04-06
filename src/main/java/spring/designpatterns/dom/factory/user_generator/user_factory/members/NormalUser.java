package spring.designpatterns.dom.factory.user_generator.user_factory.members;

import spring.designpatterns.dom.factory.user_generator.entity.UserFactory;
import java.util.ArrayList;
import java.util.List;

public class NormalUser implements Members{

    @Override
    public List<UserFactory> createUserFactory(String username, String password, String role) {
        List<UserFactory> userFactoryList = new ArrayList<>();
        userFactoryList.add(new UserFactory(username, password, role, "read"));
        return userFactoryList;
    }
}
