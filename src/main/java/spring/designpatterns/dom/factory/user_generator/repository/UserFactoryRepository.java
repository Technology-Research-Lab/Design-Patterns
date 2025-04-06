package spring.designpatterns.dom.factory.user_generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.designpatterns.dom.factory.user_generator.entity.UserFactory;

@Repository
public interface UserFactoryRepository extends JpaRepository<UserFactory, Long> {
}
