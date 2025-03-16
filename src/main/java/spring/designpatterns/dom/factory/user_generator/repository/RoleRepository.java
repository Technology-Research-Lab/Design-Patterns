package spring.designpatterns.dom.factory.user_generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.factory.user_generator.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
