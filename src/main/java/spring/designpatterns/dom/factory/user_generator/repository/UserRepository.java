package spring.designpatterns.dom.factory.user_generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.factory.user_generator.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
