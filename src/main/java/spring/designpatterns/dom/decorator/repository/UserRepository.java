package spring.designpatterns.dom.decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.decorator.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginId(String loginId);
}
