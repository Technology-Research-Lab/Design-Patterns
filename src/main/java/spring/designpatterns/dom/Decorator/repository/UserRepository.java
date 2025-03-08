package spring.designpatterns.dom.Decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.Decorator.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
