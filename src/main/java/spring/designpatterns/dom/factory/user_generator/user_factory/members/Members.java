package spring.designpatterns.dom.factory.user_generator.user_factory.members;

import spring.designpatterns.dom.factory.user_generator.entity.UserFactory;

import java.util.List;

public interface Members {
    List<UserFactory> createUserFactory(String username, String password, String role);
}
